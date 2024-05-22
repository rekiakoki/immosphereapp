package project_immobilier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page_de_choix {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	page_de_choix window = new page_de_choix();
                    window.initialize().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public page_de_choix() {
        // Constructor
    }

    public JFrame initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 165, 0));

        // Button "rechercher un bien"
        JButton btnNewButton = new JButton("rechercher un bien");
        btnNewButton.setBackground(new Color(255, 140, 0));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnNewButton.setBounds(219, 318, 327, 83);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                page_recherchebien accountChoiceWindow = new page_recherchebien ();
                 accountChoiceWindow.initialize().setVisible(true);
               
            }
        });
        frame.getContentPane().add(btnNewButton);
        
        
        
        
        JButton btnDposerUneAnnonce = new JButton("Déposer une annonce");
        btnDposerUneAnnonce.setBackground(new Color(255, 140, 0));
        btnDposerUneAnnonce.setForeground(Color.BLACK);
        btnDposerUneAnnonce.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
        btnDposerUneAnnonce.setBounds(219, 196, 327, 83);
        btnDposerUneAnnonce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                pagechoixcompte accountChoiceWindow = new pagechoixcompte();
                 accountChoiceWindow.initialize().setVisible(true);
               
            }
        });
        frame.getContentPane().add(btnDposerUneAnnonce);

       
            	
              

        return frame;
    }

    public JFrame getFrame() {
        return frame;
    }
}
