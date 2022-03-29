import java.rmi.RemoteException;

public interface ICalculate extends Remote{
    public double sqrtCalc(int rang) throws RemoteException;
}
