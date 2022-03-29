package communication.AU2021.soketTCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//cr�er un serrveur qui ecoute sur le 7676
		try {
			ServerSocket serveur= new ServerSocket(7676);
			
			while(true){
				System.out.println(" serveur d�marr�... en attente s'une demande");
				Socket demande= serveur.accept(); 
				
				System.out.println(" une nouvelle demande recue");
				
				// deleguer le traitement a un thread
				
				ClientHandler ch= new ClientHandler(demande);
				ch.start();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
//