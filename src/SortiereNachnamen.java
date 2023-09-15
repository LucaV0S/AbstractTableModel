import java.util.Comparator;

public class SortiereNachnamen implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getNachname().compareTo(o2.getNachname());
    }
}
