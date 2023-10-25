import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BasicCalculatorInterface extends Remote {
    double add(double x, double y) throws RemoteException;
    double subtract(double x, double y) throws RemoteException;
    double multiply(double x, double y) throws RemoteException;
    double divide(double x, double y) throws RemoteException;
}