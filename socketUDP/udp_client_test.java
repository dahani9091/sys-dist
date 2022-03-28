package communication.socketUDP;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class udp_client_test {
    
    public static void main(String[] args) {
        try{

            DatagramSocket socket = new DatagramSocket();

            byte[] sendData = (new String("fin a server")).getBytes();

            DatagramPacket p1 = new DatagramPacket(sendData,sendData.length,InetAddress.getByName("localhost"),8888);

            socket.send(p1);

            byte[] receiveData = new byte[1024];

            DatagramPacket p2 = new DatagramPacket(receiveData,receiveData.length);
            
            socket.receive(p2);

            String msg = new String(receiveData,0,receiveData.length);

            System.out.println(msg);


        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
