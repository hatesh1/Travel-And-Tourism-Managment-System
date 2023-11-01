import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelUsername,labelName;
    JComboBox comboId;
    JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhoneNumber;

    JRadioButton rMale, rFemale;

    JButton add, back;

    public AddCustomer(String username) {
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        labelUsername = new JLabel("");
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,90,150,25);
        add(lblId);


        comboId = new JComboBox(new  String[] {"Passport","National Identity Card","Contact Number", "City"});
        comboId.setBounds(220,90,150,25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,130,150,25);
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220,130,150,25);
        add(tfNumber);


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,170,150,25);
        add(lblName);

        labelName = new JLabel("Number");
        labelName.setBounds(220,170,150,25);
        add(labelName);


        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,210,150,25);
        add(lblGender);

        rMale = new JRadioButton("Male");
        rMale.setBounds(220,210,70,25);
        rMale.setBackground(Color.WHITE);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setBounds(300,210,70,25);
        rFemale.setBackground(Color.WHITE);
        add(rFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rMale);
        bg.add(rFemale);


        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30,250,150,25);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220,250,150,25);
        add(tfCountry);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,290,150,25);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(220,290,150,25);
        add(tfAddress);


        JLabel lblPhone = new JLabel("Phone#");
        lblPhone.setBounds(30,330,150,25);
        add(lblPhone);

        tfPhoneNumber = new JTextField();
        tfPhoneNumber.setBounds(220,330,150,25);
        add(tfPhoneNumber);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,370,150,25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220,370,150,25);
        add(tfEmail);


        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while (rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){

            String username = labelUsername.getText();
            String id = (String) comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = labelName.getText();

            String gender = null;
            if (rMale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfPhoneNumber.getText();
            String email = tfEmail.getText();


            try {
                Conn c = new Conn();
                String query = "insert into customer values ('"+username+"','"+id+"','"+number+"'," +
                        "'"+name+"','"+gender+"','"+country+"'," +
                        "'"+address+"','"+phone+"','"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Detailed Added Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("hatesh");
    }
}
