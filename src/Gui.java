import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Gui {
    JFrame mainFrame = new JFrame("Studententabelle");
    JButton delete = new JButton("Löschen");
    JButton hinzufuegen = new JButton("Hinzufügen");
    JButton sort = new JButton("Sortieren");
    JComboBox<String> comboBox = new JComboBox<>();
    JPanel buttonPanel = new JPanel();
    JScrollPane scroll = new JScrollPane();
    JTable tabel= new JTable();
    ArrayList<Student> students = new ArrayList<>();

    public Gui(final ArrayList<Student> students) {
        this.students = students;
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 400);
        BorderLayout bw = new BorderLayout();
        mainFrame.getContentPane().setLayout(bw);
        mainFrame.setVisible(true);
        StudentenTable studentenTableModel = new StudentenTable(students);
        tabel.setModel(studentenTableModel);
        scroll.setViewportView(tabel);
        mainFrame.getContentPane().add(scroll, BorderLayout.CENTER);

        mainFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(delete);
        buttonPanel.add(hinzufuegen);
        buttonPanel.add(sort);
        buttonPanel.add(comboBox);
        comboBox.addItem("-keine Ausgewählt-");
        comboBox.addItem("Nachname");
        comboBox.addItem("Vorname");
        comboBox.addItem("Matrikelnummer");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int actualRow = tabel.getSelectedRow();
                if (actualRow != -1) {
                    students.remove(actualRow);
                    studentenTableModel.fireTableDataChanged();
                }else{
                    JOptionPane.showMessageDialog(mainFrame,"Keine Zeile ausgewählt");
                }
            }
        });

        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                students.add(new Student());
                studentenTableModel.fireTableDataChanged();
            }
        });

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = String.valueOf(comboBox.getSelectedItem());
                if (select.equals("Nachname")) {
                    Collections.sort(students, new SortiereNachnamen());
                } else if (select.equals("Vorname")) {
                    Collections.sort(students, new SortiereVornamen());
                } else if (select.equals("Matrikelnummer")) {
                    Collections.sort(students, Student::compareTo);
                }else if(select.equals("-keine Ausgewählt-")){
                    JOptionPane.showMessageDialog(mainFrame, "Keine Sortierung ausgewählt!");
                }
                studentenTableModel.fireTableDataChanged();
            }
        });

        mainFrame.pack();
    }
}

