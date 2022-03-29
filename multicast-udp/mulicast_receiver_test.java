package communication.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class mulicast_receiver_test {
    
    public static void main(String[] args) {
        try{
            InetAddress group = InetAddress.getByName("255.0.0.1");

            MulticastSocket mcs = new MulticastSocket(8888);
    
            mcs.joinGroup(group);
    
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            while(true){
    
                DatagramPacket p = new DatagramPacket(receiveData,receiveData.length); 
                
                mcs.receive(p);
    
                String msg = new String(p.getData(),0,p.getLength());
    
                System.out.println(msg);

                sendData = (new String("msg from the receiver ")).getBytes();

                p.setData(sendData);
                p.setLength(sendData.length);

                mcs.send(p);
    
            }
    
        }catch(Exception e){
            System.out.println(e);
        }


    }
    




}
//