package project_immobilier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pagechoixcompte {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pagechoixcompte window = new pagechoixcompte();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pagechoixcompte() {
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

        JButton btnNewButton_1 = new JButton("J'ai un compte");
        btnNewButton_1.setForeground(new Color(139, 0, 0));
        btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnNewButton_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1.setBounds(232, 178, 327, 83);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Créer un compte");
        btnNewButton_1_1.setForeground(new Color(139, 0, 0));
        btnNewButton_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnNewButton_1_1.setBackground(new Color(255, 140, 0));
        btnNewButton_1_1.setBounds(232, 335, 327, 83);
        frame.getContentPane().add(btnNewButton_1_1);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setForeground(new Color(139, 0, 0));
        btnRetour.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        btnRetour.setBackground(new Color(255, 140, 0));
        btnRetour.setBounds(24, 507, 159, 43);
        frame.getContentPane().add(btnRetour);

        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Listener for "J'ai un compte" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                pagejaicompte loginPage = new pagejaicompte(); // Create a new instance of the login page
                loginPage.initialize().setVisible(true); // Open the login page
            }
        });

        // Listener for "Créer un compte" button
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                page_info_vc registerPage = null;
				try {
					registerPage = new page_info_vc();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // Create a new instance of the registration page
                registerPage.getFrame().setVisible(true); // Open the registration page
            }
        });

        // Listener for "Retour" button
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                page_de_choix previousPage = new page_de_choix(); // Create a new instance of the previous page
                previousPage.initialize().setVisible(true); // Open the previous page
            }
        });
		return frame;
    }

    public JFrame getFrame() {
        return frame;
    }
}

