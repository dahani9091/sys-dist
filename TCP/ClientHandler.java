package communication.AU2021.soketTCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
	private Socket socket;
	
	public ClientHandler(Socket socket){
		this.socket=socket;
		
	}
	
	public void run(){
		try {
		Scanner in =new Scanner(socket.getInputStream());
		PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
		
		out.println(" bienvenue... serveur a votre service");
		
		
		in.close();
		out.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
//