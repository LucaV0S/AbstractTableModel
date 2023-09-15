import java.util.Comparator;

public class SortiereVornamen implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getVorname().compareTo(o2.getVorname());
    }
}