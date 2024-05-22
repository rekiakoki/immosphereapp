package project_immobilier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pagedespsup {
    private Connection connection;

    private JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pagedespsup window = new pagedespsup();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pagedespsup() {
        initialize();
    }

    public JFrame initialize() {
        frame = new JFrame();
        frame.setType(JFrame.Type.POPUP);
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
        
        JButton btnNewButton_1_1_1_1 = new JButton("Suivant");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                idsup();
            }
        });
        btnNewButton_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
        btnNewButton_1_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1_1.setBounds(601, 495, 152, 44);
        frame.getContentPane().add(btnNewButton_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1 = new JButton("Retour");
        btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 frame.dispose(); // Close the current window
        		 pagecompteuser loginPage = new pagecompteuser();
                 loginPage.initialize().setVisible(true);
        	}
        });
        btnNewButton_1_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1_1_1.setBounds(10, 495, 152, 44);
        frame.getContentPane().add(btnNewButton_1_1_1_1_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setColumns(10);
        textField.setBounds(362, 250, 244, 44);
        frame.getContentPane().add(textField);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("ID du bien :");
        lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(20, 250, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1_1);
        
        JLabel lblDonnerLeNombre = new JLabel("Donner l'ID de votre bien à supprimer :");
        lblDonnerLeNombre.setForeground(Color.WHITE);
        lblDonnerLeNombre.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblDonnerLeNombre.setBounds(48, 55, 726, 62);
        frame.getContentPane().add(lblDonnerLeNombre);

        return frame;
    }

    private void idsup() {
        int idDesp;
        try {
            idDesp = Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un ID valide!");
            return;
        }

        String query = "DELETE FROM despbien WHERE id_desp = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idDesp);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Le bien a été supprimé avec succès!");
            } else {
                JOptionPane.showMessageDialog(null, "Aucun bien trouvé avec cet ID!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Une erreur est survenue lors de la suppression du bien!");
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}

