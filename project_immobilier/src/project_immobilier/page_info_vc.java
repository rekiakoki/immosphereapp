package project_immobilier;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class page_info_vc {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private Connection connection;
    private Statement statement;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    page_info_vc window = new page_info_vc();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public page_info_vc() throws ClassNotFoundException {
        initialize();
    }

    void initialize() throws ClassNotFoundException {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "irekia15");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed!");
        }

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenue sur la page d'inscription, Remplir les informations ci-dessous :");
        lblNewLabel.setBounds(10, 23, 784, 33);
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nom , Prenom :");
        lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(49, 67, 232, 52);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Mots de passe :");
        lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(49, 244, 232, 52);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Adresse email :");
        lblNewLabel_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(49, 165, 232, 52);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Numéro de téléphone :");
        lblNewLabel_1_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1.setBounds(10, 336, 334, 52);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(380, 78, 287, 41);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(380, 165, 287, 41);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(380, 255, 287, 41);
        frame.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(380, 347, 287, 41);
        frame.getContentPane().add(textField_3);

        JButton btnSuivant = new JButton("Suivant");
        btnSuivant.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnSuivant.setBackground(new Color(255, 140, 0));
        btnSuivant.setBounds(581, 507, 159, 43);
        frame.getContentPane().add(btnSuivant);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnRetour.setBackground(new Color(255, 140, 0));
        btnRetour.setBounds(50, 507, 159, 43);
        frame.getContentPane().add(btnRetour);

        btnSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                pagechoixcompte previousPage = new pagechoixcompte();
                previousPage.initialize().setVisible(true);
            }
        });

        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void saveData() {
        String nomPrenom = textField.getText();
        String email = textField_1.getText();
        String motDePasse = textField_2.getText();
        String telephone = textField_3.getText();

        String query = "INSERT INTO utilisateur (id, nom_prenom, email, mot_de_passe, telephone) " +
                       "VALUES (id.NEXTVAL, '" + nomPrenom + "', '" + email + "', '" + motDePasse + "', '" + telephone + "')";

        try {
            statement = connection.createStatement();
            statement.execute(query);
            JOptionPane.showMessageDialog(null, "Vos informations ont été bien insérées!");
        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Une erreur est survenue lors de l'insertion des informations !");
        }
    

}

           
    public JFrame getFrame() {
        return frame;
    }
}
