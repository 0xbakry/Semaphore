
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omarb
 */
public class Network {
    
      public static void main(String[] args) throws InterruptedException {
          
        ArrayList<Device> device = new ArrayList<>();
        String Dname, Dtype;
        Router router;
        
        System.out.println(System.getProperty("user.dir"));
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("What is the number of WI-FI Connections?");
        int N = input.nextInt(); //  max number of connections a router can accept
        router = new Router(N);
        
        System.out.println("What is the number of devices Clients want to connect?");
        int TC = input.nextInt(); //total number of devices that wish to connect.

        while (TC > 0) 
        {
            System.out.println("Enter DeviceName and Type");   
            Device D = new Device(input.next(), input.next(), router);
            device.add(D);
            TC--;
        }    

        for (int i = 0; i < device.size(); i++) {
            sleep(100);
            device.get(i).start();
 
        }
    }
}
