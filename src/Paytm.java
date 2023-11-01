import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {

    Paytm(){
        setBounds(500,200,800,600);

        JEditorPane pane = new JEditorPane();

        pane.setEditable(false);

        try {
            pane.setPage("http://paytm.com/rent-payment");

        }catch (Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);


        JButton back = new JButton("Back");
        back.setBounds(610,20,80,40);
//        pay.setBackground(Color.BLACK);
//        pay.setForeground(Color.WHITE);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payments();

    }
    public static void main(String[] args) {
        new Paytm();
    }
}
