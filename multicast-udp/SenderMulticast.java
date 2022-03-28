package communication.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class SenderMulticast {
	
	
	public SenderMulticast() throws IOException{
		doCommunicatewithReceiver();
	}

	public void doCommunicatewithReceiver() throws IOException{
		// groupe multicast
		InetAddress group = InetAddress.getByName("225.0.0.1");
		MulticastSocket mcs = new MulticastSocket(6789);
		mcs.joinGroup(group);
		
			while(true){
				System.out.println(" veuillez ecrire l'info a diffuser...");
				String S= (new Scanner(System.in)).nextLine();
				byte[] sendData=S.getBytes();
				
				//mettre les données dans le packet
				DatagramPacket p= new DatagramPacket(sendData, sendData.length, group,6789);
				
				System.out.println("le sender est sur le point d'envoyer un msg au groupe:"+group.getHostName());
				mcs.send(p);
				System.out.println(" msg envoyé... fermeture");
				
			}
			//mcs.close();
			// recevoir une information
			//byte[] receiveData = new byte[1024];
				
			// paquet vide
			/*DatagramPacket p2 = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("le client attend la réponse du serveur...");

			mcs.receive(p2); // client est en attente lorsqu'il a reception p2 sera rempli
			
			
			String s=new String(receiveData, 0, receiveData.length);
			System.out.println("message recu du group:"+s);
*/
			
			
			
			

		//données à envoyer
		

		
		}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new SenderMulticast();

	}

}
