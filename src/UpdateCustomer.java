import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

        JLabel labelUsername,labelName;
        JComboBox comboId;
        JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhoneNumber, tfId, tfGender;

        JRadioButton rMale, rFemale;

        JButton add, back;

        public UpdateCustomer (String username) {
            setBounds(500,200,850,550);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);

            JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
            text.setBounds(50,0,300,25);
            text.setFont(new Font("Tahoma",Font.PLAIN,20));
            add(text);


            JLabel lblUsername = new JLabel("Username");
            lblUsername.setBounds(30,50,150,25);
            add(lblUsername);

            labelUsername = new JLabel();
            labelUsername.setBounds(220,50,150,25);
            add(labelUsername);

            JLabel lblId = new JLabel("Id");
            lblId.setBounds(30,90,150,25);
            add(lblId);

            tfId = new JTextField();
            tfId.setBounds(220,90,150,25);
            add(tfId);

            JLabel lblNumber = new JLabel("Number");
            lblNumber.setBounds(30,130,150,25);
            add(lblNumber);

            tfNumber = new JTextField();
            tfNumber.setBounds(220,130,150,25);
            add(tfNumber);


            JLabel lblName = new JLabel("Name");
            lblName.setBounds(30,170,150,25);
            add(lblName);

            labelName = new JLabel();
            labelName.setBounds(220,170,150,25);
            add(labelName);


            JLabel lblGender = new JLabel("Gender");
            lblGender.setBounds(30,210,150,25);
            add(lblGender);

            tfGender = new JTextField();
            tfGender.setBounds(220,210,150,25);
            add(tfGender);


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


            add = new JButton("Update");
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

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
            Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400,80,450,300);
            add(image);

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                while (rs.next()){
                    labelUsername.setText(rs.getString("username"));
                    tfId.setText(rs.getString("id"));
                    tfNumber.setText(rs.getString("number"));
                    labelName.setText(rs.getString("name"));
                    tfGender.setText(rs.getString("gender"));
                    tfCountry.setText(rs.getString("country"));
                    tfAddress.setText(rs.getString("address"));
                    tfPhoneNumber.setText(rs.getString("phone"));
                    tfEmail.setText(rs.getString("email"));

                }
            }catch (Exception e){
                e.printStackTrace();
            }


            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == add){

                String username = labelUsername.getText();
                String id = tfId.getText();
                String number = tfNumber.getText();
                String name = labelName.getText();

                String gender = tfGender.getText();
                String country = tfCountry.getText();
                String address = tfAddress.getText();
                String phone = tfPhoneNumber.getText();
                String email = tfEmail.getText();


                try {
                    Conn c = new Conn();
                    String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = " +
                            "'"+name+"', gender = '"+gender+"', country = '"+country+"', address = " +
                            "'"+address+"', phone = '"+phone+"', email = '"+email+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                    setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }else {
                setVisible(false);
            }
        }

        public static void main(String[] args) {
            new UpdateCustomer("hatesh");
        }
    }


