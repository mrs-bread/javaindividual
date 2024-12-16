import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGroupPanel extends JPanel {
    // Поля для ввода данных о студенте
    public JTextField nameField=new JTextField(20);
    public JTextField surnameField=new JTextField(20);
    public JTextField idField=new JTextField(10);
    public JTextField majorField=new JTextField(20);
    public JTextField gpaField=new JTextField(10);
    // Кнопки для управления списком студентов
    public JButton addButton =new JButton("Add");
    public JButton removeButton=new JButton("Remove");
    public JButton sortGpaButton=new JButton("Sort by GPA");
    public JButton sortSurnameButton=new JButton("Sort by Last Name");
    // Текстовое поле для отображения списка студентов
    public JTextArea studentTextArea = new JTextArea(10,30);
    private StudentGroup group;
    private ArrayList<Student> students;
    StudentGroupPanel(StudentGroup group){
        this.group=group;
        this.students=group.getStudents();
        setLayout(new BorderLayout());
        // Панель для полей ввода данных о студенте
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Surname:"));
        inputPanel.add(surnameField);
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Major:"));
        inputPanel.add(majorField);
        inputPanel.add(new JLabel("GPA:"));
        inputPanel.add(gpaField);
        add(inputPanel, BorderLayout.NORTH); // Размещаем панель вверху
        // Панель с кнопками
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(sortGpaButton);
        buttonPanel.add(sortSurnameButton);
        add(buttonPanel, BorderLayout.SOUTH); // Размещаем панель снизу
        // Текстовое поле со скроллингом для вывода списка студентов
        JScrollPane scrollPane = new JScrollPane(studentTextArea);
        studentTextArea.setEditable(false);
        add(scrollPane, BorderLayout.CENTER); // Размещаем текстовое поле в центре

        addButton.addActionListener(this::addStudent);
        removeButton.addActionListener(this::removeStudent);
        sortGpaButton.addActionListener(this::sortByAverageGrade);
        sortSurnameButton.addActionListener(this::sortBySurname);
    }
    // Метод для обновления текста в текстовом поле
    void updateText(String text){
        studentTextArea.setText(text);
    }

    // Метод для очистки полей ввода
    void clearFields(){
        nameField.setText("");
        surnameField.setText("");
        idField.setText("");
        majorField.setText("");
        gpaField.setText("");
    }

    // Метод для добавления студента
    private void addStudent(ActionEvent e) {
            //Получаем данные из полей ввода
            String name = nameField.getText();
            String surname = surnameField.getText();
            int id = Integer.parseInt(idField.getText());
            String major = majorField.getText();
            double gpa = Double.parseDouble(gpaField.getText());

            //Создаём объект Student
            Student student = new Student(name, surname, id, major, gpa);
            //Добавляем студента в модель
            group.AddStudent(student);
            //Обновляем отображение списка студентов
            updateList();
            //Очищаем поля ввода
            clearFields();
    }

    // Метод для удаления студента
    private void removeStudent(ActionEvent e) {
            //Получаем ID студента для удаления
            int idToRemove = Integer.parseInt(idField.getText());
            //Ищем студента с указанным ID и удаляем его
            for (int i = 0; i < group.getStudents().size(); i++) {
                if (group.getStudents().get(i).getId() == idToRemove) {
                    group.removeStudent(i);
                    updateList();
                    clearFields();
                    return;
                }
            }
    }

    // Метод для сортировки по среднему баллу
    private void sortByAverageGrade(ActionEvent e) {
        group.SortByGpa();
        updateList();
    }

    // Метод для сортировки по фамилии
    private void sortBySurname(ActionEvent e) {
        group.SortByLastName();
        updateList();
    }

    //Метод для обновления списка студентов в текстовом поле
    private void updateList(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<students.size();i++){
            sb.append(students.get(i).toString()).append("\n");
        }
        updateText(sb.toString());
    }


}
