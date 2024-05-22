package project_immobilier;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class pagemesprop {

    private JFrame frame;
    private JTable table;
    private Connection connection;
    private Statement statement;
    private JButton btnNewButton;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pagemesprop window = new pagemesprop();
                    window.frame.setVisible(true);
                    window.executeSelectQuery("SELECT * FROM despbien");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public pagemesprop() {
        initialize();
    }

    public JFrame initialize() { frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        frame.setBounds(100, 100, 809, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 764, 471);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(222, 184, 135));
        scrollPane.setViewportView(table);
        
        btnNewButton = new JButton("Retour");
        btnNewButton.setBounds(38, 527, 89, 23);
        frame.getContentPane().add(btnNewButton);
        
        lblNewLabel = new JLabel("Ceci est votre liste de proprieter");
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
        lblNewLabel.setBounds(20, 11, 657, 29);
        frame.getContentPane().add(lblNewLabel);

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "irekia15");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
             // re-throw the exception after logging it
        }
		return frame;
    }

    // Method to execute the SELECT query and display the results
    public void executeSelectQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            displaySearchResults(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet, Statement, and Connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Method to display the search results in the table
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
