
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author omarb
 */
public class Device extends Thread {
    private String DeviceName;
    private String DeviceType;
    private int id;
    Router MyRouter;
    
    public Device(String DeviceName,String DeviceType, Router r){
        this.DeviceName=DeviceName;
        this.DeviceType=DeviceType;
        MyRouter = r;
        id = 1;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setDeviceType(String DeviceType) {
        this.DeviceType = DeviceType;
    }
    
    @Override
    public void run(){
        try {
            MyRouter.connect(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
