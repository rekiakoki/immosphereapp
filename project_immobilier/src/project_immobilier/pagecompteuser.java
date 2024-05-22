package project_immobilier;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pagecompteuser {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	pagecompteuser window = new pagecompteuser();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pagecompteuser() {
        initialize();
    }

   public JFrame initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenues :");
        lblNewLabel.setForeground(new Color(139, 0, 0));
        lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 45));
        lblNewLabel.setBounds(61, 35, 334, 87);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton_1 = new JButton("ajouter des propriétés");
        btnNewButton_1.setForeground(new Color(139, 0, 0));
        btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnNewButton_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1.setBounds(232, 107, 327, 83);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("supprimer un propriétaire");
        btnNewButton_1_1.setForeground(new Color(139, 0, 0));
        btnNewButton_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnNewButton_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1.setBounds(232, 217, 327, 83);
        frame.getContentPane().add(btnNewButton_1_1);
        
        JButton btnNewButton_1_1_1 = new JButton("Mes propriétaires");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fermer la fenêtre actuelle
                pagemesprop mespropPage = new pagemesprop();
                mespropPage.initialize().setVisible(true);

                // Appeler la méthode pour afficher les résultats de la recherche
                mespropPage.executeSelectQuery("SELECT * FROM despbien");
            }
        });
        btnNewButton_1_1_1.setForeground(new Color(139, 0, 0));
        btnNewButton_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnNewButton_1_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1_1.setBounds(232, 345, 327, 83);
        frame.getContentPane().add(btnNewButton_1_1_1);
        
        JButton btnSuivant = new JButton("suivant");
        btnSuivant.setForeground(new Color(139, 0, 0));
        btnSuivant.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnSuivant.setBackground(new Color(255, 140, 0));
        btnSuivant.setBounds(581, 507, 159, 43);
        frame.getContentPane().add(btnSuivant);

        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Listener for "J'ai un compte" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                page_desbien loginPage = null;
				loginPage = new page_desbien();
                loginPage.initialize().setVisible(true);
            }
        });

        // Listener for "Créer un compte" button
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose(); // Close the current window
                pagedespsup loginPage = null;
				loginPage = new pagedespsup();
                loginPage.initialize().setVisible(true);
            }
        });
		return frame;
    }

    public JFrame getFrame() {
        return frame;
    }
}

