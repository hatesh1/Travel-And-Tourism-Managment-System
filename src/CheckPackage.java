import javax.swing.*;
import java.awt.*;


public class CheckPackage extends JFrame {

    CheckPackage() {
        setBounds(450,200,900,600);

        String[] package1 = {"GOLD PACKAGE","6 DAYS AND 7 NIGHTS",
                "AIRPORT ASSISTANCE ","HALF DAY CITY TOUR", "DAILY BUFFET",
                "SOFT DRINKS FREE", "FULL DAY 3 ISLAND CRUISE","ENGLISH SPEAKING GUIDE",
                "BOOK PACKAGE","SUMMER SPECIAL","RS 12000/","package1.jpg"};
        String[] package2 = {"SILVER PACKAGE","5 DAYS AND 6 NIGHTS",
                "TOLL FREE AND ENTRANCE FREE TICKETS","MEET AND GREET AT AIRPORT",
                "WELCOME DRINKS ON ARRIVAL","SPECIAL DISCOUNT","NIGHT SAFARI","CRUISE WITH DINNER",
                "BOOK NOW","WINTER SPECIAL","RS 22000/","package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","4 DAYS AND 5 NIGHTS",
                "RETURN AIRFARE","FREE CLUBBING, HORSE RIDING, & OTHER GAMES",
                "HARD DRINKS FREE","SPECIAL DISCOUNT","DAILY BUFFET","BBQ DINNER","BOOK NOW",
                "WINTER SPECIAL","RS 32000/","package3.jpg"};


        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("package 1",null, p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("package 2",null, p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("package 3",null, p3);

        add(tab);


        setVisible(true);

    }
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,60 ,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l2);


        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,110 ,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,160 ,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,210 ,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l5);


        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,260 ,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,310 ,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,360 ,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(60,430 ,300,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(80,480 ,300,30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l10);

        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(500,480 ,300,30);
        l11.setForeground(Color.cyan);
        l11.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350,20,500,300);
        p1.add(l12);

        return p1;
    }

    public static void main(String[] args) {

        new CheckPackage();

    }
}
