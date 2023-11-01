import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, Password;
    JTextField tfUsername,tfPassword;
    Login() {
        setSize(900,400);
        setLocation(250,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        //p1.setLayout(null);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(60,20,100,25);
        lblUsername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(60,60,300,30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);



        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60,110,100,25);
        lblPassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(60,150,300,30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);



        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        Password = new JButton("Forget Password");
        Password.setBounds(130,250,130,30);
        Password.setBackground(new Color(133,193,233));
        Password.setForeground(Color.WHITE);
        Password.setBorder(new LineBorder(new Color(133,193,233)));
        Password.addActionListener(this);
        p2.add(Password);



        JLabel text = new JLabel("Trouble in login....");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            try {
                String username = tfUsername.getText();
                String pass = tfPassword.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username Or Password");
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == signup){
            setVisible(false);
            new Signup();

        }else {
            setVisible(false);
            new ForgetPassword();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
