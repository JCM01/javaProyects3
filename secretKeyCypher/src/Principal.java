import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Principal {
	private static Usuario usuario;
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Scanner lector = new Scanner(System.in);
		
		 
			 
				System.out.println("Escribe tu usuario: ");
				String user = lector.nextLine();
				System.out.println("Contraseña: ");
				String password = lector.nextLine();
				
				
				usuario = new Usuario(user, password);
				
				FileOutputStream file;
				ObjectOutputStream buffer;
				FileInputStream file1;
				ObjectInputStream buffer1;
				
				File fich = new File(user+".obj");
				
				if(fich.exists()) {
					System.out.println("Existe el usuario");
					try {
						file1=new FileInputStream(user+".obj");
						buffer1=new ObjectInputStream(file1);
					} catch(IOException e){
						System.out.println("No se ha podido abrir el fichero");
						System.out.println(e.getMessage());
						return;
					}
					try {
						usuario = (Usuario) buffer1.readObject();
						if(password.equals(usuario.getPassword())) {
							System.out.println("Contraseña correcta");
						}else {
							System.out.println("Contraseña incorrecta");
							System.exit(1);
						}
						
					}catch(IOException e){
						System.out.println("Error al escribir en el fichero");
					}
				
				}
				else {
					System.out.println("No existe el fichero");
					usuario = new Usuario(user, password);
				}
			 
		 
		String opc="";
		
		
		do {
			System.out.println("1. Añadir una nueva recomendacion");
			System.out.println("2. Realizar un listado con todas las recomendaciones");
			System.out.println("3. Realizar de recomendaciones para un rango de edad");
			System.out.println("4. Terminar el programa");
			System.out.println("Que opcion eliges del 1 al 4");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				
				String titulo;
				String autor;
				String edad;
				
				System.out.println("Nueva recomendacion: ");
				titulo = lector.nextLine();
				System.out.println("Dime el autor");
				autor = lector.nextLine();
				System.out.println("Dime la edad");
				edad = lector.nextLine();
				
				usuario.add(titulo, autor, edad);
				
				break;
			case "2":
				
				int indice=0;
				
				for (int i = 0; i < usuario.getRecomendaciones().size(); i++) {
					System.out.println(indice+ " --- " +usuario.getRecomendaciones().get(i).toString());
					indice++;
				}
				
				break;
			case "3":
				
				int indice2=0;
				
				System.out.println("Dime la edad maxima");
				int max = lector.nextInt();
				System.out.println("Dime la edad minima");
				int min = lector.nextInt();
				lector.nextLine();
				for (int i = 0; i < usuario.getRecomendaciones().size(); i++) {
					Cuento cuentos = usuario.getRecomendaciones().get(i);
					int cuentosOtros = Integer.parseInt(cuentos.getRecomendadoPara());
					if (cuentosOtros <= max && cuentosOtros >= min) {
						System.out.println(indice2+ " --- " +usuario.getRecomendaciones().get(i).toString());
						indice2++;
					}
					
				}
				
				break;
			case "4":
				System.out.println("Fin del programa");
				break;
		
			default:
				System.out.println("Opción incorrecta");
			}
		}while (!opc.equals("4"));
		
		lector.close();
		
		if(!fich.exists()) {
			try {
				file= new FileOutputStream(user+".obj");
				buffer= new ObjectOutputStream(file);
			}catch(IOException e) {
				System.out.println("Error al abrir fichero");
				System.out.println(e.getMessage());	
				return;
				}
			try {
				buffer.writeObject(usuario);
				System.out.println("Se ha guardado en el fichero");
			}catch(IOException e1) {
				System.out.println("Se producido un error al guadarlo fichero");
				System.out.println(e1.getMessage());
			}
		}
	}

		public static String cifrar(String password) throws NoSuchAlgorithmException, NoSuchPaddingException,
		InvalidKeyException, IllegalBlockSizeException, BadPaddingException

{
	KeyGenerator generador = KeyGenerator.getInstance("AES");
	
	System.out.println("1. Este es el generador de claves");
	
	SecretKey clave = generador.generateKey();

	System.out.println("2. La clave se ha genereador");
	
	Cipher Lector = Cipher.getInstance("AES");
	

	System.out.println("3. Este el lector de clave");
	
	Lector.init(Cipher.ENCRYPT_MODE, clave);

	
	String msin = password;

	byte[] bytesmensajeSin = msin.getBytes();
	
	byte[] bytesMensajeCifrado = Lector.doFinal(bytesmensajeSin);
	
	String mensajeCifrado = new String(bytesMensajeCifrado);
	
	System.out.println("Mensaje Original: " + msin);
	System.out.println("Mensaje Cifrado: " + mensajeCifrado);
	return mensajeCifrado;
	
}
	






}



