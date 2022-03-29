package communication.socketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class ReceiverUDP {
		private int port;
	
	public ReceiverUDP(int p) throws IOException{
		this.port=p;
		doCommunicateWithClient(port);
	}
	
	public void doCommunicateWithClient(int port) throws IOException{
		
		DatagramSocket receiverSocket = new DatagramSocket(port);
		System.out.println("le serveur est sur �coute...");
		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		while(true){
			DatagramPacket p = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("le receiver attend un nouveau paquet...");
			
			receiverSocket.receive(p);
			
			
			String s1 = new String(p.getData(), 0, p.getLength());
			System.out.println(" nouveau paquet recu du sender ... le Message est: "+s1);
			
			sendData=(new String("on est le :"+LocalDateTime.now())).getBytes();
			
			// le paquet recu contient l'adresse du client
			
			p.setData(sendData);
			p.setLength(sendData.length);
			
			receiverSocket.send(p);
			System.out.println("le receiver a envoy� un message...");

	
	
			
		}	
	}

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		int port=Integer.parseInt(args[0]);
		System.out.println("argument 2:"+args[1]);
		Scanner s= new Scanner(System.in);
		port= Integer.parseInt(s.nextLine());
		s.close();
		new ReceiverUDP(port);
	}

}
//