import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentenTable extends AbstractTableModel {
    String[] columnNames = {"Nachname", "Vorname", "Matrikelnummer"};
    ArrayList<Student> students;
    public StudentenTable(ArrayList<Student> students){
        this.students=students;

    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return students.get(row).getNachname();
            case 1:
                return students.get(row).getVorname();
            case 2:
                return students.get(row).getMatrikelNr();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Student entry = students.get(row);
        switch (col) {
            case 0:
                entry.setNachname((String) value);
                break;
            case 1:
                entry.setVorname((String) value);
                break;
            case 2:
                entry.setMatrikelNr(Integer.parseInt((String) value));
                break;
        }
    }
}
