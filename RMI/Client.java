import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        ICalculate sun = (Calculate) Naming.lookup("rmi://localhost:8888/getsqt");
        System.out.println(sun.sqrtCalc(20));
    }
}
