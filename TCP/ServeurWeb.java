package communication.AU2021.soketTCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurWeb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket sw =new ServerSocket(8000);
			while(true){
				System.out.println("attente d'une demande...");
				Socket client= sw.accept();
				String entete="HTTP/1.1 200 OK\n\n";
				String corps="<HTML><TITLE>Mon serveur web</TITLE>Cette page a �t� envoy�e par mon <B>Serveur</B></HTML>";
				String message= entete+corps;
				PrintWriter out= new PrintWriter(client.getOutputStream(), true);
				out.println(message);
				client.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
//