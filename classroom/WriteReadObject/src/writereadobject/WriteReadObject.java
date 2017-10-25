/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author tonyc
 */
public class WriteReadObject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Writes an object to a binary file
        ObjectOutputStream fileOut;
        TestObject obj = new TestObject(1, "test1", 2.0);
        String fileName = JOptionPane.showInputDialog("Enter the file's name");
        
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(fileName));
            fileOut.writeObject(obj);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IOException " + ex.getMessage());
        }
        
            // End write
            //Reads object form a binary file
            TestObject objIn;//"In" de entrada
        try {
            ObjectInputStream fileInt = new ObjectInputStream(new FileInputStream(fileName));
            objIn = (TestObject) fileInt.readObject();
            objIn.display();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IOException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de ClassNotFoundException " + ex.getMessage());
        }
        
    }
    
}
