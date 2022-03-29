package communication.multicast;

import java.net.MulticastSocket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class multicast_sender_test {

    public static void main(String[] args) {
        try{
            InetAddress group = InetAddress.getByName("255.0.0.1");
            MulticastSocket mcs = new MulticastSocket(8888);
            mcs.joinGroup(group);

            while(true){
                System.out.println("Please kteb chi 9lwa: ");
                String msg = (new Scanner(System.in)).nextLine();
                byte[] sendData = msg.getBytes();
                DatagramPacket p = new DatagramPacket(sendData,sendData.length,group,8888);

                mcs.send(p);

                // receive
                byte[] receiveData = new byte[1024];

                DatagramPacket p2 = new DatagramPacket(receiveData,receiveData.length);
                
                mcs.receive(p2);

                String received_msg = new String(receiveData,0,receiveData.length);

                System.out.println(received_msg);


            }//

        }catch(Exception e){
            System.out.println(e);
        }
        

    }
    
}
