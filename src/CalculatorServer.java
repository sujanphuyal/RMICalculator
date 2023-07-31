import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImplementation obj = new CalculatorImplementation();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://Calculator",obj);
            System.out.println("Server is running...!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
