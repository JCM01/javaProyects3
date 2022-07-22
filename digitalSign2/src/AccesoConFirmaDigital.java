
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.util.Scanner;
 
public class AccesoConFirmaDigital {
	public static void main(String[] args) {
		MensajeFirmado mf;
		try {
			// Obtenemos el objeto del fichero con la firma digital.
			FileInputStream fichero = new FileInputStream("firma.obj");
			ObjectInputStream buffer = new ObjectInputStream(fichero);
			mf = (MensajeFirmado) buffer.readObject();
			buffer.close();
			fichero.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer fichero de firma digital");
			System.out.println("Excepci�n de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			return;
		}
		Scanner lector = new Scanner(System.in);
		try {
			// Creaci�n de un objeto Signature (gestor de firmas).
			Signature firmadorVerificador = Signature.getInstance("DSA");
			// Obtenci�n de la clave p�blica (PublicKey)
			// y configuraci�n del objeto Signature.
			firmadorVerificador.initVerify(mf.getClavePublica());
			
			// Configurar el mensaje (mensaje secreto) que se desea verificar. 
			System.out.println("�Cu�l es el mensaje secreto?");
			String mensajeSecreto = lector.nextLine();
			firmadorVerificador.update(mensajeSecreto.getBytes());
			// Verificar el mensaje secreto.
			boolean ok = firmadorVerificador.verify(mf.getFirma());
			if (ok) {
				System.out.println("Verificaci�n OK, Bienvenido al sistema");
			} else {
				System.out.println("La verificaci�n ha fallado, Acceso denegado");
			}
 
			lector.close();
		} catch (GeneralSecurityException e) {
			System.out.println("Error en la verificaci�n de la firma digital");
			System.out.println("Excepci�n de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			lector.close();
			return;
		}
	}
}

