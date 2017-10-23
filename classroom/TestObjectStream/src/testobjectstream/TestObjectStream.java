/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjectstream;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tonyc
 */
public class TestObjectStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            //CREATE AN OUTPUT STREAM FOR THE FILE
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.data"));
            //WRITEN A STRING, DOUBLE VALUE, AND OBJECT TO THE FILE
            output.writeUTF("Carlos Antonio Mendez Mendez");
            output.writeDouble(67.8);
            output.writeObject(new Date());
            output.close();
            //Colse output steam
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, " Ther is an error of NotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " Ther is an error IOException " + ex.getMessage());
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.data"));

            String name = input.readUTF();
            double weight = input.readDouble();
            Date date = (Date) input.readObject();
            System.out.println(" name " + name + " weight " + weight + " date " + date);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, " Ther is an error of NotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " Ther is an error IOException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ther is an error of ClassNotFooundException " + ex.getMessage());
        }
    }
}
