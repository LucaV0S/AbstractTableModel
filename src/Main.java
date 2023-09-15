import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student s1= new Student("Jan-Luca", "Voss", 1234567, true);
        Student s2= new Student("Zoe", "Plog", 8849382, true);
        Student s3 = new Student("Max", "Mustermann", 9253738, false);
        ArrayList<Student> students= new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Gui g1 = new Gui(students);
    }
}