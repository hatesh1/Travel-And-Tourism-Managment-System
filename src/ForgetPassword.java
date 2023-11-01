import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfUsername, tfName, tfQuestion, tfAnswer, tfPassword;
    JButton search,retrieve, back;
    public ForgetPassword() {
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/Forgotpassword.jpg"));
        Image i2 = il.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);


        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40,20,100,25);
        lblUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(220,20,150,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);


        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40,60,100,25);
        lblName.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(220,60,150,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);


        JLabel lblQuestion = new JLabel("Security Question");
        lblQuestion.setBounds(40,100,150,25);
        lblQuestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblQuestion);

        tfQuestion = new JTextField();
        tfQuestion.setBounds(220,100,150,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);


        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setBounds(40,140,150,25);
        lblAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(220,140,150,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);


        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);


        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40,180,150,25);
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(220,180,150,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);


        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){

            try {
                String query =  "select * from account where username = '"+tfUsername.getText()+"'";
                Conn c = new Conn();
               ResultSet rs =  c.s.executeQuery(query);
               while (rs.next()){
                   tfName.setText(rs.getString("name"));
                   tfQuestion.setText(rs.getString("security"));
               }

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == retrieve){

            try {
                String query =  "select * from account where answer = '"+tfAnswer.getText()+"' AND username = '"+tfUsername.getText()+"'" ;
                Conn c = new Conn();
                ResultSet rs =  c.s.executeQuery(query);
                while (rs.next()){
                    tfPassword.setText(rs.getString("password"));
                    //tfQuestion.setText(rs.getString("security"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
