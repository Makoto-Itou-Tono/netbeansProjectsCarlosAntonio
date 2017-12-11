/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;

import java.io.Serializable;

/**
 *
 * @author tonyc
 */
public class TestObject implements Serializable{//"Serializable" para que el archivo pueda ser escrito y leido en un objeto Binario
    private int id;
    private String text;
    public double number;
    
    //**************************************************************************

    public TestObject(int id, String text, double number) {
        this.id = id;
        this.text = text;
        this.number = number;
    }
    //**************************************************************************
    public void display(){
        System.out.println(this.id);
        System.out.println(this.text);
        System.out.println(this.number);
    }
    //**************************************************************************
    
}
