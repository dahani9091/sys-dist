package communication.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReceiverMulticast {
	
	public ReceiverMulticast() throws IOException{
		doCommunicateWithClient();
	}
	
	public void doCommunicateWithClient(){
		
		try{
		InetAddress group = InetAddress.getByName("225.0.0.1");
		MulticastSocket mcs = new MulticastSocket(6789);
		mcs.joinGroup(group);

		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		while(true){
			DatagramPacket p = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("le receiver attend un nouveau paquet...");
			
			mcs.receive(p);
			
			String s1 = new String(p.getData(), 0, p.getLength());
			System.out.println(" nouveau paquet recu ... le Message est: "+s1);
			
		}	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new ReceiverMulticast();
	}

}
