import java.util.List;

public class StudentGroupMain {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();
        group.AddStudent(new Student("Иван", "Иванов", 1, "Математика", 3.8));
        group.AddStudent(new Student("Петр", "Петров", 2, "Физика", 3.5));
        group.AddStudent(new Student("Екатерина", "Васильева", 3, "Информатика", 4.0));
        group.AddStudent(new Student("Анна", "Александрова", 4, "Математика", 3.9));

        group.print();

        System.out.println("\nПоиск студента по ID (ID=2):");
        Student foundStudent = group.SearchById(2);
        System.out.println(foundStudent);

        System.out.println("\nПоиск студентов по специальности (Математика):");
        List<Student> mathStudents = group.SearchByMajor("Математика");
        for (int i=0;i<mathStudents.size();i++) {
            System.out.println(mathStudents.get(i));
        }

        System.out.println("\nУдаление студента с ID=1:");
        group.DelById(1);
        group.print();

        System.out.println("\nСортировка по фамилии:");
        group.SortByLastName();
        group.print();

        System.out.println("\nСортировка по среднему баллу (по убыванию):");
        group.SortByGpa();
        group.print();
    }
}
