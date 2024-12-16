import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {
    JLabel l1,l2,l3;
    JTextField f1,f2,f3;
    JButton b1;
    MyPanel(){
        l1=new JLabel("Операнд 1");
        add(l1);
        f1=new JTextField(10);
        add(f1);
        l2=new JLabel("Операнд 2");
        add(l2);
        f2=new JTextField(10);
        add(f2);
        l3=new JLabel("Результат");
        add(l3);
        f3=new JTextField(10);
        add(f3);
        b1=new JButton("+");
        MyListener m=new MyListener();
        b1.addActionListener(m);
        add(b1);
    }
    class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int p1=Integer.parseInt(f1.getText());
            int p2=Integer.parseInt(f2.getText());
            int p3=p2+p1;
            f3.setText(String.valueOf(p3));
        }
    }
}
