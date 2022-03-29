import java.rmi.server.UnicastRemoteObject;

public class Calculate extends UnicastRemoteObject implements ICalculate{

    public Calculate(){
        super();
    }

    public double sqrtCalc(int rang) throws RemoteException{
        double sum=0;

        for (int i=0;i<=rang;i++){
            sum += Math.sqrt(i);
        }
        return sum;
    }
    
}
