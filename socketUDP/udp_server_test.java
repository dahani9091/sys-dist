package communication.socketUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class udp_server_test {
    public static void main(String[] args) {
        try{
            DatagramSocket server_socket = new DatagramSocket(8888);

            byte[] receiveData = new byte[1024];
            byte[] sendData    = new byte[1024];

            while(true){
                DatagramPacket p1 = new DatagramPacket(receiveData,receiveData.length);
                server_socket.receive(p1);

                String msg_from_client = new String(p1.getData(),0,p1.getLength());

                System.out.println(msg_from_client);

                sendData = (new String("Hello from the server")).getBytes();

                p1.setData(sendData);
                p1.setLength(sendData.length);

                server_socket.send(p1);

            }
            
            


        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
//