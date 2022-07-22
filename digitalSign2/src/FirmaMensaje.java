import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
 
public class FirmaMensaje {
	public static void main(String[] args) throws GeneralSecurityException {
		System.out.println("VAMOS A CREAR UNA FIRMA DIGITAL");
		
		// Creamos el par de claves y obtenemos la clave privada.
		KeyPairGenerator generadorDeClaves = KeyPairGenerator.getInstance("DSA");
		generadorDeClaves.initialize(1024);
		KeyPair claves = generadorDeClaves.generateKeyPair();
		PrivateKey clavePrivada = claves.getPrivate();
		
		// Creamos el objeto que servir� como gestor de la firma digital.
		Signature firmadorVerificador = Signature.getInstance("DSA");
		
		/*
		 * Configuramos nuestro objeto Signature para que utilice la clave privada 
		 * durante el proceso de cifrado asim�trico del resumen hash.
		 */
		firmadorVerificador.initSign(clavePrivada);
		
		/*
		 *  Actualizamos el objeto Signature, a�adiendo los datos del mensaje secreto. 
		 *  A partir de estos datos se crear� el resumen hash que despu�s ser� cifrado.
		 */
		byte[] mensajeSecreto = "amelia.gonzalez@campusfp.es/1234".getBytes();
		firmadorVerificador.update(mensajeSecreto);
		
		/*
		 * Con el m�todo sign() obtenemos la firma digital, que est� formada por 
		 * el resumen hash del mensaje cifrado con la clave privada.
		 */
		byte[] firmaDigital = firmadorVerificador.sign();
		System.out.println("Firma: " + new String(firmaDigital));
		
		/*
		 * Guardamos en disco la firma digital junto a la clave publica 
		 * asociada a la clave privada con la que se cifr� el resumen hash
		 */
		MensajeFirmado mf = new MensajeFirmado(claves.getPublic(), firmaDigital);
		guardar(mf);
	}
 
	private static void guardar(MensajeFirmado mf) {
		try {
			FileOutputStream fichero = new FileOutputStream("firma.obj");
			ObjectOutputStream buffer = new ObjectOutputStream(fichero);
			buffer.writeObject(mf);
			buffer.close();
			fichero.close();
			System.out.println("El fichero de firma digital se ha creado con �xito");
		} catch (IOException e) {
			System.out.println("Error al grabar fichero de firma digital");
			System.out.println("Excepci�n de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
