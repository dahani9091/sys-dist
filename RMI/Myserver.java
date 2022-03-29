import java.rmi.Naming;

public class Myserver {
    
    public static void main(String[] args) {
        ICalculate sub = new Calculate();

        Naming.rebind("rmi://localhost:8888/getsqt", sub);

        

    }

}
