
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ITestRMI extends Remote {
	public ArrayList<Pregunta> getPreguntas() throws RemoteException;
	public Pregunta getPregunta() throws RemoteException;
	public ArrayList<Pregunta> get5Azar() throws RemoteException;
}
