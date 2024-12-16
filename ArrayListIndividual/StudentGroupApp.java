import javax.swing.*;

public class StudentGroupApp extends JFrame {
    public StudentGroupApp(){
        StudentGroup group =new StudentGroup();
        StudentGroupPanel panel=new StudentGroupPanel(group);
        add(panel);
        setTitle("Student Group");
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
