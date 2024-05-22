package project_immobilier;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.Timer;

public class mainApplication {

    private JFrame frameDeGarde;
    private JFrame frameDeChoix;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainApplication window = new mainApplication();
                    window.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Start the application.
     */
    public void start() {
        // Show page de garde
        page_de_garde pageDeGarde = new page_de_garde();
        frameDeGarde = pageDeGarde.initialize();
        frameDeGarde.setVisible(true);

        // Set a timer to close page de garde and open page de choix after 3 seconds (3000 milliseconds)
        Timer timer = new Timer(3000, e -> {
            frameDeGarde.dispose(); // Close page de garde
            openPageDeChoix(); // Open page de choix
        });
        timer.setRepeats(false); // Ensure the timer only runs once
        timer.start();
    }

    /**
     * Open page de choix.
     */
    private void openPageDeChoix() {
        page_de_choix pageDeChoix = new page_de_choix();
        frameDeChoix = pageDeChoix.initialize();
        frameDeChoix.setVisible(true);
    }
}
