
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	public static void main(String[] args) {
		String host;
		int puerto = 5054;
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("No se ha podido obtener la dirección IP");
			System.out.println(e.getMessage());
			return;
		}
		try {
			Registry registro = LocateRegistry.createRegistry(puerto);
			TestRMI test = new TestRMI();
	/////////////////////////////////////////////////////////////////
	// Añade el objeto test creado al registro de objetos remotos //		////////////////////////////////////////////////////////////////
			
			registro.rebind("miPregunta", test);
			
			System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
		} catch (RemoteException e) {
			System.out.println("No se ha podido registrar el servicio");
			System.out.println(e.getMessage());
		}
	}
}
