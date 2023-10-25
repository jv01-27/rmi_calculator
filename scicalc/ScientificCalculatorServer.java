import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ScientificCalculatorServer extends UnicastRemoteObject implements ScientificCalculatorInterface {
    public ScientificCalculatorServer() throws RemoteException {
        // Constructor vacío
    }

    public double sin(double x) throws RemoteException {
        return Math.sin(x);
    }

    public double cos(double x) throws RemoteException {
        return Math.cos(x);
    }

    public double tan(double x) throws RemoteException {
        return Math.tan(x);
    }

    public double log(double x) throws RemoteException {
        return Math.log10(x);
    }

    public double ln(double x) throws RemoteException {
        return Math.log(x);
    }

    public double sqrt(double x) throws RemoteException {
        return Math.sqrt(x);
    }
    
    public double factorial(double x) throws RemoteException {
        if (x < 0) {
            throw new RemoteException("Factorial is not defined for negative numbers.");
        }
        double result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            ScientificCalculatorServer scientificCalculatorServer = new ScientificCalculatorServer();
            Naming.rebind("ScientificCalculatorService", scientificCalculatorServer);
            System.out.println("ScientificCalculatorServer is running.");
        } catch (Exception e) {
            System.err.println("ScientificCalculatorServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
