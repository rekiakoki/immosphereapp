package project_immobilier;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class add_photo { public static File uploadPhoto(JFrame parentFrame) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

    int returnValue = fileChooser.showOpenDialog(parentFrame);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        return fileChooser.getSelectedFile();
    } else {
        return null;
    }

}}
