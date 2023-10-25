import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BasicCalculatorServer extends UnicastRemoteObject implements BasicCalculatorInterface {
    public BasicCalculatorServer() throws RemoteException {
        // Constructor vacío
    }

    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    public double subtract(double x, double y) throws RemoteException {
        return x - y;
    }

    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

    public double divide(double x, double y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Division by zero is not allowed.");
        }
        return x / y;
    }

    public static void main(String[] args) {
        try {
            BasicCalculatorServer basicCalculatorServer = new BasicCalculatorServer();
            Naming.rebind("BasicCalculatorService", basicCalculatorServer);
            System.out.println("BasicCalculatorServer is running.");
        } catch (Exception e) {
            System.err.println("BasicCalculatorServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
