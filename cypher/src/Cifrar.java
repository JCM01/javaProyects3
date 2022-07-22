import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class Cifrar {
	public static void main(String args[]) {
		try {
			KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			KeyPair claves = generador.generateKeyPair();
			System.out.println("Paso 2: Se ha obtenido el par de claves");
			Cipher descifrador = Cipher.getInstance("RSA");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			descifrador.init(Cipher.ENCRYPT_MODE, claves.getPublic());
			System.out.println
("Paso 4: Hemos configurado el descifrador para usar clave pública");
			String mensajeOriginal = "La cripta mágica";
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);
			String mensajeCifrado = new String(bytesMensajeCifrado);
			System.out.println("Paso 5: Hemos preparado y cifrado el mensaje original");
			System.out.println("Mensaje Original: " + mensajeOriginal);
			System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			System.out.println
("AHORA VAMOS A DESCIFRAR EL MENSAJE CIFRADO USANDO LA CLAVE PRIVADA");
			descifrador.init(Cipher.DECRYPT_MODE, claves.getPrivate());
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
		} catch (GeneralSecurityException e) {
			System.out.println("Error al cifrar o descifrar el mensaje");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
