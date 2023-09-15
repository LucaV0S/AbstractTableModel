public class Student implements Comparable<Student>{
    private String vorname;
    private String nachname;
    private int matrikelNr;

    public Student(String vorname, String nachname, int matrikelNr, boolean istMatrikuliert){
        this.vorname=vorname;
        this.nachname=nachname;
        this.matrikelNr=matrikelNr;
        this.istMatrikuliert=istMatrikuliert;
    }

    public Student(){
        this("----","---",0,false);
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    public boolean isIstMatrikuliert() {
        return istMatrikuliert;
    }

    public void setIstMatrikuliert(boolean istMatrikuliert) {
        this.istMatrikuliert = istMatrikuliert;
    }

    private boolean istMatrikuliert;

    public String toString(){
        return "Student[ vorname= "+vorname+" nachname= "+nachname+" matrikelnummer= "+ matrikelNr+ " istMatrikuliert= "+ istMatrikuliert;
    }

    @Override
    public int compareTo(Student o) {
        return this.getMatrikelNr()- o.getMatrikelNr();
    }
}
