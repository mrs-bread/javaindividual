import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame(){
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel p=new MyPanel();
        add(p);
        setVisible(true);
    }
}
