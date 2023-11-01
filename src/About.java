import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    public About() {
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
        l1.setBounds(8,20,500,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);
        String s = "Travel and tourism management system is used to book a tour from anywhere in the\n" +
                "world by a single dynamic website which will help the user to know all about the places and tour\n" +
                "details in a single website. The admin can add packages to the website from a certain travel\n" +
                "agents and hotels by create a tour page. Then the users can sign in and book each project, they\n" +
                "can be confirmed by the admin in their manage booking page. The user can see the confirmation\n" +
                "in their my booking page. It is a easiest platform for all travelers which can be easily booked and\n" +
                "know the all details. Tour Management system is a dynamic website for tourism business. It is\n" +
                "dynamic and responsive web design. It is also called travel technology solution for agencies &\n" +
                "tour operation. Nearly Everyone goes on a vacation for this ‘a Tourism management system’\n" +
                "would play a vital role in planning the perfect trip. The tourism management system allows the\n" +
                "user of the system access all the details such as location, events, etc.";

        TextArea area = new TextArea(s,10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200,420,100,25);
//        pay.setBackground(Color.BLACK);
//        pay.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
