import java.util.Comparator;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private String major;
    private double gpa;

    Student(String firstName, String lastName, int id, String major, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.major = major;
        this.gpa = gpa;
    }

    String getFirstName(){return firstName;}
    String getLastName(){return lastName;}
    int getId(){return id;}
    String getMajor(){return major;}
    double getGpa(){return gpa;}
    void setFirstName(String firstName){this.firstName=firstName;}
    void setLastName(String lastName){this.lastName=lastName;}
    void setId(int id){this.id=id;}
    void setMajor(String major){this.major=major;}
    void setGpa(double gpa){this.gpa=gpa;}
    public String toString() {
        return firstName+ " " + lastName + ", id=" + id + ", Специальность=" + major +", Средний балл=" + gpa;
    }

    void Print(){
        System.out.println(firstName+ " " + lastName + ", id=" + id + ", Специальность=" + major +", Средний балл=" + gpa);
    }

    public static Comparator<Student> lastNameComparator =new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            return s1.getLastName().compareTo(s2.getLastName());
        }
    };

    public static Comparator<Student> gpaComparator =new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getGpa(),s2.getGpa());
        }
    };
}
