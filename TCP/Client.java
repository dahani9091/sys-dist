package communication.AU2021.soketTCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		try {
			InetAddress adr= InetAddress.getByName("localhost");
			Socket socket= new Socket(adr, 7676);
			
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
			Scanner clavier= new Scanner(System.in);
			System.out.println("entrer votre nickname");
			String s=clavier.nextLine();
			
			///lecture du message recu du serveur
			
			//conversaation
			//condition d'arret mot stop ecrit au clavier
			//while(codition){
			
			out.println("nickname:"+s);
			
			
			in.close();
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
//