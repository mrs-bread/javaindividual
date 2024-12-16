import java.util.ArrayList;

public class StudentGroup {
    ArrayList<Student> students;
    StudentGroup(){students=new ArrayList<Student>();}
    void AddStudent(Student s){
        students.add(s);
    }

    void print(){
        System.out.println("Студенческая Группа:");
        for(int i=0;i<students.size();i++)
            students.get(i).Print();
    }
    ArrayList<Student> getStudents(){
        return students;
    }

    void  removeStudent(int index){
        students.remove(index);
    }
    void DelById(int id){
        int p=-1;
        for(int i=0;i<students.size();i++){
            if(id==students.get(i).getId())
                p=i;
        }
        if(p>-1){
            students.remove(p);
            System.out.println("Студент успешно удалён");
        }
        else System.out.println("Такого студента нет");
    }

    Student SearchById(int id){
        int p=-1;
        for(int i=0;i<students.size();i++){
            if(id==students.get(i).getId())
                p=i;
        }
        if(p>-1){
            return students.get(p);
        }
        return null;
    }

    ArrayList<Student> SearchByLastName(String lastName){
        ArrayList<Student> found = new ArrayList<>();
        for(int i=0;i<students.size();i++){
            if(lastName.equals(students.get(i).getLastName()))
                found.add(students.get(i));
        }
        return found;
    }

    ArrayList<Student> SearchByMajor(String major){
        ArrayList<Student> found = new ArrayList<>();
        for(int i=0;i<students.size();i++){
            if(major.equals(students.get(i).getMajor()))
                found.add(students.get(i));
        }
        return found;
    }

    void SortByLastName(){students.sort(Student.lastNameComparator);}
    void SortByGpa(){students.sort(Student.gpaComparator);}
}
