package project_immobilier;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class page_resultabien {

    private JFrame frame;
    private JTable table;
    private ResultSet resultSet;

    public page_resultabien(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public JFrame initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        frame.setBounds(100, 100, 809, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 764, 500);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(222, 184, 135));
        scrollPane.setViewportView(table);

        displaySearchResults(resultSet);

        return frame;
    }

   
		
	

    public void displaySearchResults(ResultSet resultSet) {
        try {
            // Get the column count
            int columnCount = resultSet.getMetaData().getColumnCount();
            // Create a DefaultTableModel
            DefaultTableModel model = new DefaultTableModel();
            // Add columns to the model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }
            // Add rows to the model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                model.addRow(row);
            }
            // Set the model to the table
            table.setModel(model);

            // Afficher un message après avoir affiché les résultats
            JOptionPane.showMessageDialog(frame, "Voici les résultats de votre recherche. Vous pouvez contacter le propriétaire directement.", "Résultats de la recherche", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public JFrame getFrame() {
        return frame;
    }
}
