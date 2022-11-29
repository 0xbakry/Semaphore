/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.Thread.sleep;

/**
 *
 * @author omarb
 */
public class Router {
     private boolean [] active;
    private int maxDevices = 0, currentActive = 0;
    Semaphore semaphore;
    
    Router (int max)
    {
        maxDevices = max;
        semaphore = new Semaphore(max);
        active = new boolean[max];
    }
    
    public synchronized int connect (Device d) throws InterruptedException
    {
        semaphore.Wait(d);
        for (int i = 0; i < maxDevices; i++)
        {
            if (!active[i])
            {
                currentActive++;
                d.setid(currentActive);
                active[i] = true;
                sleep(200);
                break;
            }
        }
        return d.getid();
    }
    
    public synchronized void disconnect(Device device)
    {
        currentActive--;
        active[device.getid()] = false;
        notify();
        System.out.println("Connection " + device.getid() + ": " + device.getDeviceName() + " Logged out");
    }

    public synchronized void arrived(Device  d){
        System.out.println( d.getDeviceName() +" (" + d.getDeviceType() + ")" +" arrived");
    }    
    
}
