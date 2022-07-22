
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
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			return;
		}
		Scanner lector = new Scanner(System.in);
		try {
			// Creación de un objeto Signature (gestor de firmas).
			Signature firmadorVerificador = Signature.getInstance("DSA");
			// Obtención de la clave pública (PublicKey)
			// y configuración del objeto Signature.
			firmadorVerificador.initVerify(mf.getClavePublica());
			
			// Configurar el mensaje (mensaje secreto) que se desea verificar. 
			System.out.println("¿Cuál es el mensaje secreto?");
			String mensajeSecreto = lector.nextLine();
			firmadorVerificador.update(mensajeSecreto.getBytes());
			// Verificar el mensaje secreto.
			boolean ok = firmadorVerificador.verify(mf.getFirma());
			if (ok) {
				System.out.println("Verificación OK, Bienvenido al sistema");
			} else {
				System.out.println("La verificación ha fallado, Acceso denegado");
			}
 
			lector.close();
		} catch (GeneralSecurityException e) {
			System.out.println("Error en la verificación de la firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			lector.close();
			return;
		}
	}
}

