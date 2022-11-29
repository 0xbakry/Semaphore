/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author omarb
 */
public class Semaphore  {
    
    protected int value = 0;

    public void WriteOnFile(String word){
        try {
            PrintWriter p =new PrintWriter("out.txt");
            p.println(word);
            p.close();
     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Semaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Semaphore(int value) 
    {
        this.value = value;
    }
    public synchronized void Wait(Device d)
    {
        value-- ;
        if (value < 0){
            try {
                WriteOnFile(d.getDeviceName() + " arrived and waiting");
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else
            WriteOnFile(d.getDeviceName() + " arrived ");
             
    }
    public synchronized void Signal() {
        value++ ; 
        if (value <= 0) 
            notify() ;
    }
    
}