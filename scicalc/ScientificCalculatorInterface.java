import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ScientificCalculatorInterface extends Remote {
    double sin(double x) throws RemoteException;
    double cos(double x) throws RemoteException;
    double tan(double x) throws RemoteException;
    double log(double x) throws RemoteException;
    double ln(double x) throws RemoteException;
    double sqrt(double x) throws RemoteException;
    double factorial(double x) throws RemoteException;
}