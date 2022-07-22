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
		
		// Creamos el objeto que servirá como gestor de la firma digital.
		Signature firmadorVerificador = Signature.getInstance("DSA");
		
		/*
		 * Configuramos nuestro objeto Signature para que utilice la clave privada 
		 * durante el proceso de cifrado asimétrico del resumen hash.
		 */
		firmadorVerificador.initSign(clavePrivada);
		
		/*
		 *  Actualizamos el objeto Signature, añadiendo los datos del mensaje secreto. 
		 *  A partir de estos datos se creará el resumen hash que después será cifrado.
		 */
		byte[] mensajeSecreto = "amelia.gonzalez@campusfp.es/1234".getBytes();
		firmadorVerificador.update(mensajeSecreto);
		
		/*
		 * Con el método sign() obtenemos la firma digital, que está formada por 
		 * el resumen hash del mensaje cifrado con la clave privada.
		 */
		byte[] firmaDigital = firmadorVerificador.sign();
		System.out.println("Firma: " + new String(firmaDigital));
		
		/*
		 * Guardamos en disco la firma digital junto a la clave publica 
		 * asociada a la clave privada con la que se cifró el resumen hash
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
			System.out.println("El fichero de firma digital se ha creado con éxito");
		} catch (IOException e) {
			System.out.println("Error al grabar fichero de firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
