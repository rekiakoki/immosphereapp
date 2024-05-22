package project_immobilier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class pagedescription {

    private JFrame frame;
    private JLabel lblPhoto1;
    private JLabel lblPhoto2;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pagedescription window = new pagedescription();
                    window.initialize();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pagedescription() {
        // Constructor
    }

    public void initialize() {
        frame = new JFrame("Uploader des Photos");
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 599);
        frame.getContentPane().setLayout(null);

        lblPhoto1 = new JLabel();
        lblPhoto1.setBounds(10, 10, 200, 200);
        frame.getContentPane().add(lblPhoto1);

        lblPhoto2 = new JLabel();
        lblPhoto2.setBounds(220, 10, 200, 200);
        frame.getContentPane().add(lblPhoto2);

        JLabel lblDescription = new JLabel("Ajouter la description de votre bien :");
        lblDescription.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblDescription.setBounds(10, 220, 348, 52);
        frame.getContentPane().add(lblDescription);

        textArea = new JTextArea();
        textArea.setBounds(10, 280, 410, 200);
        frame.getContentPane().add(textArea);

        JLabel lblNewLabel_1_1_1 = new JLabel("Clic sur ce bouton pour ajouter des photos :");
        lblNewLabel_1_1_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(450, 180, 338, 30);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        JButton btnUploadPhoto1 = new JButton("Uploader une Photo");
        btnUploadPhoto1.setForeground(new Color(139, 0, 0));
        btnUploadPhoto1.setBackground(new Color(255, 140, 0));
        btnUploadPhoto1.setBounds(450, 220, 200, 30);
        frame.getContentPane().add(btnUploadPhoto1);

        JButton btnUploadPhoto2 = new JButton("Uploader une autre photo");
        btnUploadPhoto2.setForeground(new Color(139, 0, 0));
        btnUploadPhoto2.setBackground(new Color(255, 140, 0));
        btnUploadPhoto2.setBounds(450, 260, 200, 30);
        frame.getContentPane().add(btnUploadPhoto2);

        btnUploadPhoto1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectAndDisplayPhoto(lblPhoto1);
            }
        });

        btnUploadPhoto2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectAndDisplayPhoto(lblPhoto2);
            }
        });

        frame.setVisible(true);
    }

    private void selectAndDisplayPhoto(JLabel label) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(image));
        }
    }

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}
