package project_immobilier;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class page_recherchebien {
    private JFrame frame;
    private JTextField typeField;
    private JTextField localisationField;
    private JTextField prixField;
    private JTextField surfaceField;
    private Connection connection;
    private JButton btnNewButton_1_1_1_1;
    private JTextField textField;
    private JLabel lblNewLabel_4;
    private JButton btnNewButton_1_1_1;
    private JLabel lblNewLabel_5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    page_recherchebien window = new page_recherchebien();
                    window.initialize().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public page_recherchebien() {
        // Constructor
    }

    public JFrame initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 165, 0));
      
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "irekia15");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed!");
        }
        
        
        JLabel lblNewLabel = new JLabel("Localisation :");
        lblNewLabel.setForeground(new Color(139, 0, 0));
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel.setBounds(50, 100, 150, 30);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Type :");
        lblNewLabel_1.setForeground(new Color(139, 0, 0));
        lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(50, 150, 150, 30);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Prix :");
        lblNewLabel_2.setForeground(new Color(139, 0, 0));
        lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(50, 200, 150, 30);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Surface :");
        lblNewLabel_3.setForeground(new Color(139, 0, 0));
        lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(50, 250, 150, 30);
        frame.getContentPane().add(lblNewLabel_3);

        typeField = new JTextField();
        typeField.setBounds(200, 100, 150, 30);
        frame.getContentPane().add(typeField);
        typeField.setColumns(10);

        localisationField = new JTextField();
        localisationField.setBounds(200, 150, 150, 30);
        frame.getContentPane().add(localisationField);
        localisationField.setColumns(10);

        prixField = new JTextField();
        prixField.setBounds(200, 200, 150, 30);
        frame.getContentPane().add(prixField);
        prixField.setColumns(10);

        surfaceField = new JTextField();
        surfaceField.setBounds(200, 250, 150, 30);
        frame.getContentPane().add(surfaceField);
        surfaceField.setColumns(10);
        
        btnNewButton_1_1_1_1 = new JButton("Recherche");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
        		rechercher();
        	}
        });
        btnNewButton_1_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnNewButton_1_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1_1.setBounds(515, 449, 152, 44);
        frame.getContentPane().add(btnNewButton_1_1_1_1);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(200, 305, 150, 30);
        frame.getContentPane().add(textField);
        
        lblNewLabel_4 = new JLabel("louer ou vender?");
        lblNewLabel_4.setForeground(new Color(139, 0, 0));
        lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(31, 305, 150, 30);
        frame.getContentPane().add(lblNewLabel_4);
        
        btnNewButton_1_1_1 = new JButton("Retour :");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose(); // Close the current window
       		 page_de_choix loginPage = null;
				loginPage = new page_de_choix();
                loginPage.initialize().setVisible(true);
       	}
        });
        btnNewButton_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnNewButton_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1.setBounds(86, 449, 152, 44);
        frame.getContentPane().add(btnNewButton_1_1_1);
        
        lblNewLabel_5 = new JLabel("Donner les information de votre recherche :");
        lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(50, 11, 473, 72);
        frame.getContentPane().add(lblNewLabel_5);

        JButton btnNewButton = new JButton("Rechercher");
        btnNewButton.setBackground(new Color(255, 140, 0));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
        btnNewButton.setBounds(100, 350, 200, 50);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rechercher();
            }
        });
       
        return frame;
    }

    private void rechercher() {
        String localisation = localisationField.getText();
        String type = typeField.getText();
        String prix = prixField.getText();
        String surface = surfaceField.getText();

        // Construire la requête SQL en fonction des valeurs saisies
        String query = "SELECT * FROM despbien WHERE localisation = ? AND type = ? AND prix <= ? AND INTERFACE <= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, localisation);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, prix);
            preparedStatement.setString(4, surface);

            ResultSet resultSet = preparedStatement.executeQuery();
            // Afficher les résultats dans une autre fenêtre
            page_resultabien resultWindow = new page_resultabien(resultSet);
            resultWindow.initialize().setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


