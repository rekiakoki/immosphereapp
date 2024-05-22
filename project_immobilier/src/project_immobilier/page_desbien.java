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

public class page_desbien {
    private Connection connection;

    private JFrame frame;
    private JTextField wilayaV;
    private JTextField municipalV;
    private JTextField typeV;
    private JTextField louerV;
    private JTextField interfaceV;
    private JTextField prix;
    private JTextField num;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    page_desbien window = new page_desbien();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public page_desbien() {
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

        JLabel lblNewLabel = new JLabel("Ajouter les informations à propos de votre bien :");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 35));
        lblNewLabel.setBounds(10, 11, 726, 62);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Localisation (wilaya) :");
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(20, 124, 276, 44);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Adresse du bien :");
        lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(20, 180, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Type de votre bien :");
        lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(10, 69, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        wilayaV = new JTextField();
        wilayaV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        wilayaV.setBounds(362, 75, 244, 44);
        frame.getContentPane().add(wilayaV);
        wilayaV.setColumns(10);

        municipalV = new JTextField();
        municipalV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        municipalV.setColumns(10);
        municipalV.setBounds(362, 130, 244, 44);
        frame.getContentPane().add(municipalV);

        typeV = new JTextField();
        typeV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        typeV.setColumns(10);
        typeV.setBounds(362, 185, 244, 44);
        frame.getContentPane().add(typeV);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("A louer ou à vendre ?");
        lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1.setBounds(20, 234, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        louerV = new JTextField();
        louerV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        louerV.setColumns(10);
        louerV.setBounds(362, 240, 244, 44);
        frame.getContentPane().add(louerV);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Surface du bien :");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1_1.setBounds(20, 289, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1);

        interfaceV = new JTextField();
        interfaceV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        interfaceV.setColumns(10);
        interfaceV.setBounds(362, 295, 244, 44);
        frame.getContentPane().add(interfaceV);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Le prix :");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1_1_1.setBounds(20, 344, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);

        prix = new JTextField();
        prix.setFont(new Font("Tahoma", Font.PLAIN, 15));
        prix.setColumns(10);
        prix.setBounds(362, 350, 244, 44);
        frame.getContentPane().add(prix);
        
        JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("le numero de tele:");
        lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1_1_1_1.setBounds(20, 421, 276, 44);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1_1);
        
        num = new JTextField();
        num.setFont(new Font("Tahoma", Font.PLAIN, 15));
        num.setColumns(10);
        num.setBounds(362, 421, 244, 44);
        frame.getContentPane().add(num);
        
        JButton btnNewButton_1_1_1_1 = new JButton("Suivant");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                saveData();
            }
        });
        btnNewButton_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
        btnNewButton_1_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1_1.setBounds(601, 495, 152, 44);
        frame.getContentPane().add(btnNewButton_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1 = new JButton("Retoure");
        btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 frame.dispose(); // Close the current window
        		 pagecompteuser loginPage = null;
 				loginPage = new pagecompteuser();
                 loginPage.initialize().setVisible(true);
        	}
        });
        btnNewButton_1_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1_1_1.setBounds(10, 495, 152, 44);
        frame.getContentPane().add(btnNewButton_1_1_1_1_1);

        return frame;
    }

    private void saveData() {
        String type = wilayaV.getText();
        String local = municipalV.getText();
        String adress = typeV.getText();
        String louerOuVendre = louerV.getText();
        String superficie = interfaceV.getText();
        String prixPropriete = prix.getText();
        String numero = num.getText();

        String query = "INSERT INTO despbien (id_desp, type, localisation, adress, louervender, interface, prix, numerotele) VALUES (id.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, local);
            preparedStatement.setString(3, adress);
            preparedStatement.setString(4, louerOuVendre);
            preparedStatement.setString(5, superficie);
            preparedStatement.setString(6, prixPropriete);
            preparedStatement.setString(7, numero);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vos informations ont été bien insérées!");
        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Une erreur est survenue lors de");
        }}

    public JFrame getFrame() {
        return frame;
    }
}
