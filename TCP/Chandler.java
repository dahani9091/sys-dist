public class Chandler {
    Socket socket;

    public Socket(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            Scanner in = new Scanner(this.socket.getInputStream());
            PrintWriter out = new PrintWriter(this.socket.getOutputStream());
    
            
            out.println("Welcome to the server")
    
            String line = in.nextLine();
    
            print("Message from the client: "+line);

            this.socket.close();
            in.close();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
//