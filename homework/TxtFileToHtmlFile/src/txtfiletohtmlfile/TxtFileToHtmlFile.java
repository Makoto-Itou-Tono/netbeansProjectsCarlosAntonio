/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txtfiletohtmlfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author tonyc
 */
public class TxtFileToHtmlFile {

    private String filename;
    private PrintWriter output;
    private File file;
    private String firstLine = null, firstParagraph = null, secondParagraph = null, thirdParagraph = null;

    /**
     * @param args the command line arguments
     */
    public void ReadPersonFile() {
        JFileChooser fileChooser = new JFileChooser(); // Se crea un objeto de tipo JFlieChooser
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            this.file = fileChooser.getSelectedFile(); // Obtenemos todo lo relcionado al archivo no el archivo en si
            try {
                //Create a Scanner for the file
                Scanner input = new Scanner(this.file);
                //Read text from the file
                firstLine = input.nextLine();
                firstParagraph = input.nextLine() + input.nextLine() + input.nextLine();
                secondParagraph = input.nextLine() + input.nextLine() + input.nextLine() + input.nextLine() + input.nextLine();
                thirdParagraph = input.nextLine() +input.nextLine() +input.nextLine() +input.nextLine();
                System.out.println(firstLine + "\n" + firstParagraph + "\n" + secondParagraph + "\n" + thirdParagraph);
                input.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null/*se refiere a la posiscion en la que se mostraria el error, se le pone el nombre de la ventana para que aparesca en esa ventana centrado el error*/, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file Selected");
        }
    }

    public void createFile(String name) throws FileNotFoundException {
        this.filename = name;
        this.file = new File(this.filename);
        if (!this.file.exists()) {
            this.output = new PrintWriter(new FileOutputStream(this.file, true));
        } else {
            JOptionPane.showMessageDialog(null, "The file already exists");
        }
    }

    public void WritePerson() throws FileNotFoundException {

        if (this.file.exists()) {
            this.output = new PrintWriter(new FileOutputStream(this.file, true));
            this.output.println(
                    "<html>\n"
                    + "<head>\n"
                    + "<title>" + this.firstLine + "</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>" + this.firstLine + "</h1>\n"
                    + "<p>" + this.firstParagraph + "</p>\n"
                    + "<p>" + this.secondParagraph + "</p>\n"
                    + "<p>" + this.thirdParagraph + "</p>\n"
                    + "</body>\n"
                    + "</html>\n");
        } else {
            JOptionPane.showMessageDialog(null, "The file already exists");
        }
        this.output.close();
    }

    public static void main(String[] args) {
        // TODO code application logic here

        TxtFileToHtmlFile t = new TxtFileToHtmlFile();
            t.ReadPersonFile();
            
            String nameFile = null;
        nameFile = JOptionPane.showInputDialog(nameFile);
        try {
            t.createFile(nameFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, " FileNotFoundException " + ex.getMessage());
        }
        try {
            t.WritePerson();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtFileToHtmlFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
