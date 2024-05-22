package project_immobilier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class pagejaicompte {

    private JFrame frame;
    private JTextField textField_1; // Email text field
    private JTextField textField_2; // Password text field
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pagejaicompte window = new pagejaicompte();
                    window.initialize().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pagejaicompte() {
        initialize();
        initializeDBConnection();
    }

    private void initializeDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "irekia15");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed!");
        }
    }

    public JFrame initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenue sur la page d'inscription, Remplir les informations ci-dessous :");
        lblNewLabel.setBounds(10, 23, 784, 33);
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1_1 = new JLabel("Mots de passe :");
        lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(49, 244, 232, 52);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Adresse email :");
        lblNewLabel_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(49, 165, 232, 52);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(380, 165, 287, 41);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(380, 255, 287, 41);
        frame.getContentPane().add(textField_2);

        JButton btnSuivant = new JButton("Suivant");
        btnSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String email = textField_1.getText();
                String motDePasse = textField_2.getText();

                String query = "SELECT COUNT(*) FROM utilisateur WHERE email = ? AND mot_de_passe = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, motDePasse);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next() && resultSet.getInt(1) > 0) {
                            JOptionPane.showMessageDialog(frame, "Connexion réussie !");
                            frame.dispose();
                            pagecompteuser accountChoiceWindow =  new pagecompteuser  ();
                            accountChoiceWindow.initialize().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Email ou mot de passe incorrect !");
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Erreur lors de la connexion !");
                }}
        });
        btnSuivant.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnSuivant.setBackground(new Color(255, 140, 0));
        btnSuivant.setBounds(581, 507, 159, 43);
        frame.getContentPane().add(btnSuivant);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnRetour.setBackground(new Color(255, 140, 0));
        btnRetour.setBounds(50, 507, 159, 43);
        frame.getContentPane().add(btnRetour);

        frame.setType(Type.POPUP);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                pagechoixcompte previousPage = new pagechoixcompte();
                previousPage.initialize().setVisible(true);
            }
        });

        return frame;
    }

    public JFrame getFrame() {
        return frame;
    }
}


