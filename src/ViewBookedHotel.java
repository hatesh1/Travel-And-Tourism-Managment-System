import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    ViewBookedHotel(String username){
        setBounds(400,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);


        JLabel lblId = new JLabel("Hotel Name");
        lblId.setBounds(30,90,150,25);
        add(lblId);

        JLabel labelPackage = new JLabel();
        labelPackage.setBounds(220,90,150,25);
        add(labelPackage);


        JLabel lblNumber = new JLabel("Total Persons");
        lblNumber.setBounds(30,130,150,25);
        add(lblNumber);

        JLabel labelPersons = new JLabel();
        labelPersons.setBounds(220,130,150,25);
        add(labelPersons);


        JLabel lblDays = new JLabel("Total Days");
        lblDays.setBounds(30,170,150,25);
        add(lblDays);

        JLabel labelDays = new JLabel();
        labelDays.setBounds(220,170,150,25);
        add(labelDays);

        JLabel lblAc = new JLabel("AC/ Non-AC");
        lblAc.setBounds(30,210,150,25);
        add(lblAc);

        JLabel labelAc = new JLabel();
        labelAc.setBounds(220,210,150,25);
        add(labelAc);

        JLabel lblFood = new JLabel("Food Included?");
        lblFood.setBounds(30,250,150,25);
        add(lblFood);

        JLabel labelFood = new JLabel();
        labelFood.setBounds(220,250,150,25);
        add(labelFood);



        JLabel lblName = new JLabel("Id");
        lblName.setBounds(30,290,150,25);
        add(lblName);

        JLabel labelId = new JLabel();
        labelId.setBounds(220,290,150,25);
        add(labelId);


        JLabel lblGender = new JLabel("Number");
        lblGender.setBounds(30,330,150,25);
        add(lblGender);

        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(220,330,150,25);
        add(labelNumber);


        JLabel lblCountry = new JLabel("Phone");
        lblCountry.setBounds(30,370,150,25);
        add(lblCountry);

        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(220,370,150,25);
        add(labelPhone);



        JLabel lblAddress = new JLabel("Total Cost");
        lblAddress.setBounds(30,410,150,25);
        add(lblAddress);

        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(220,410,150,25);
        add(labelPrice);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,460,100,25);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        try {
            Conn c = new Conn();
            String query = "select * from bookHotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPackage.setText(rs.getString("name"));
                labelPrice.setText(rs.getString("price"));
                labelPhone.setText(rs.getString("phone"));
                labelPersons.setText(rs.getString("persons"));
                labelFood.setText(rs.getString("food"));
                labelAc.setText(rs.getString("ac"));
                labelDays.setText(rs.getString("days"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){

        setVisible(false);
    }

    public static void main(String[] args) {

        new ViewBookedHotel("hatesh");
    }

}

