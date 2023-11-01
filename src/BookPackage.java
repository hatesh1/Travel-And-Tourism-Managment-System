import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    Choice cPackage;
    JTextField tfPersons;
    String username;
    JLabel labelUsername,labelId, labelNumber, labelPhone, labelPrice;
    JButton checkPrice, bookPackage, back;
    public BookPackage(String username) {
        this.username = username;


        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblUsername.setBounds(40,70,100,20);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setFont(new Font("Tahoma", Font.PLAIN,16));
        labelUsername.setBounds(250,70,200,20);
        add(labelUsername);


        JLabel lblPackage = new JLabel("Select package");
        lblPackage.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblPackage.setBounds(40,110,150,20);
        add(lblPackage);

        cPackage = new Choice();
        cPackage.add("GOLD PACKAGE");
        cPackage.add("SILVER PACKAGE");
        cPackage.add("BRONZE PACKAGE");
        cPackage.setBounds(250,110,200,20);
        add(cPackage);


        JLabel lblPersons = new JLabel("Total Persons");
        lblPersons.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblPersons.setBounds(40,150,150,25);
        add(lblPersons);

        tfPersons = new JTextField("1");
        tfPersons.setBounds(250,150,200,25);
        add(tfPersons);


        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblId.setBounds(40,190,150,20);
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(250,190,200,25);
        add(labelId);


        JLabel lblNumber = new JLabel("Number");
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblNumber.setBounds(40,230,150,25);
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(250,230,150,25);
        add(labelNumber);



        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblPhone.setBounds(40,270,150,20);
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250,270,200,25);
        add(labelPhone);


        JLabel lblTotal = new JLabel("Total Price");
        lblTotal.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblTotal.setBounds(40,310,150,25);
        add(lblTotal);

        labelPrice = new JLabel();
        labelPrice.setBounds(250,310,150,25);
        add(labelPrice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60,380,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200,380,120,25);
        bookPackage.addActionListener(this);
        add(bookPackage);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550,50,500,300);
        add(l12);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkPrice){
            String pack = cPackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("GOLD PACKAGE")){
                cost += 12000;

            } else if (pack.equals("SILVER PACKAGE")){
                cost += 22000;

            } else {
                cost += 32000;
            }
            int persons = Integer.parseInt(tfPersons.getText());
            cost *= persons;
            labelPrice.setText("RS "+ cost);

        } else if (ae.getSource()== bookPackage) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("insert into bookPackage values('"+labelUsername.getText()+"'," +
            "'"+cPackage.getSelectedItem()+"','"+tfPersons.getText()+"'," +
            "'"+labelId.getText()+"','"+labelNumber.getText()+"'," +
            "'"+labelPhone.getText()+"','"+labelPrice.getText()+"')");

            JOptionPane.showMessageDialog(null,"Package Booked Successfully");
            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("hatesh");

    }
}
