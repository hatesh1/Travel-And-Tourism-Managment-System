import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton create, back;
    JTextField tfName, tfUsername, tfPassword, tfAnswer;
    Choice security;

    Signup() {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD,14));
        lblUsername.setBounds(50,20,125,25);
        p1.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(190,20,180,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);


        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD,14));
        lblName.setBounds(50,60,125,25);
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(190,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);


        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD,14));
        lblPassword.setBounds(50,100,125,25);
        p1.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(190,100,180,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);


        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setFont(new Font("Tahoma", Font.BOLD,14));
        lblSecurity.setBounds(50,140,125,25);
        p1.add(lblSecurity);

        security = new Choice();
        security.add("Your Mother Name");
        security.add("Your Favorite Teacher Name");
        security.add("Your Best Friend Name");
        security.add("Your Lucky Number");
        security.setBounds(190,140,180,25);
        p1.add(security);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD,14));
        lblAnswer.setBounds(50,180,125,25);
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(190,180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);


        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);


        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == create){
        String username = tfUsername.getText();
        String name = tfName.getText();
        String password = tfPassword.getText();
        String question = security.getSelectedItem();
        String answer= tfAnswer.getText();


        String query = "insert into account values ('"+username+"'," +
        " '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";

        try {
            Conn c = new Conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Account Created Successfully");
            setVisible(false);
            new Login();

        }catch (Exception e){
            e.printStackTrace();
        }


        } else if (ae.getSource()==back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {

        new Signup();
    }
}
