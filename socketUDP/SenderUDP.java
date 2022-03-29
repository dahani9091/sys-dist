package communication.socketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SenderUDP {
	
	
	public SenderUDP() throws IOException{
		doCommunicatewithServer();
	}
	public void doCommunicatewithServer() throws IOException{
		String host="localhost"; //127.0.0.1
		InetAddress addr =InetAddress.getByName(host);
		
		// cr�ation du socket encore vide
		DatagramSocket socket= new DatagramSocket();
		
		//donn�es � envoyer
		byte[] sendData=(new String("bonjour!!!")).getBytes();
		
		//mettre les donn�es dans le packet
		DatagramPacket p= new DatagramPacket(sendData, sendData.length, addr,7676);
		
		System.out.println("le client est sur le point d'envoyer un msg au serveur:"+addr.getHostName());
		socket.send(p);
		
		// recevoir une information
		byte[] receiveData = new byte[1024];
			
		// paquet vide
		DatagramPacket p2 = new DatagramPacket(receiveData, receiveData.length);
		System.out.println("le client attend la r�ponse du serveur...");

		socket.receive(p2); // client est en attente lorsqu'il a reception p2 sera rempli
		
		
		String s=new String(receiveData, 0, receiveData.length);
		System.out.println("message recu du serveur:"+s);
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new SenderUDP();

	}

}
//