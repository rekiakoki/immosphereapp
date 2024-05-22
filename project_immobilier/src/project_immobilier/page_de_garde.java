package project_immobilier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class page_de_garde {

    private JFrame frame;
    private JLabel lblImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    page_de_garde window = new page_de_garde();
                    window.initialize().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public page_de_garde() {
        // Constructor
    }

    /**
     * Initialize the contents of the frame.
     */
    public JFrame initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        // Background color
        frame.getContentPane().setBackground(new Color(255, 165, 0));

        // Display the text "immosphère"
        JLabel lblText = new JLabel("immosphère");
        lblText.setBackground(new Color(255, 255, 255));
        lblText.setForeground(new Color(255, 228, 225)); // Text color in white
        lblText.setFont(new Font("Viner Hand ITC", Font.PLAIN, 80));
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setBounds(50, 30, 700, 100);
        frame.getContentPane().add(lblText);

        // Load and display the initial image (logo.png)
        lblImage = new JLabel();
        lblImage.setBounds(235, 154, 300, 300); // Adjusted bounds to be below the title
        frame.getContentPane().add(lblImage);

        // Set the initial image
        setImage("logo.png");

        return frame;
    }

    // Method to set the image to the JLabel
    private void setImage(String imagePath) {
        try {
            System.out.println("Loading image from: " + imagePath);
            ImageIcon icon = new ImageIcon(this.getClass().getResource(imagePath));
            Image img = icon.getImage();
            int width = lblImage.getWidth();
            int height = lblImage.getHeight();
            System.out.println("Label width: " + width + ", Label height: " + height);
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.err.println("Error loading image: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
