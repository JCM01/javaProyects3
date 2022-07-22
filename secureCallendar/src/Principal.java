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
	static Scanner lector;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		lector = new Scanner(System.in);
		Agenda agenda = null;
		int opc = 0;

		File fichero = new File("agenda.dat");
		if (fichero.exists())
			agenda = leerFichero();
		// Generamos la clave para el algoritmo AES y lo asociarl a la agenda.
		else {
			try {
				KeyGenerator generador = KeyGenerator.getInstance("AES");
				SecretKey clave = generador.generateKey();
				agenda = new Agenda();
				agenda.setClave(clave);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		Cipher descifrador = null;
		try {
			descifrador = Cipher.getInstance("AES");

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		while (opc != 5) {
			mostrarMenu();
			opc = lector.nextInt();
			lector.nextLine(); 
			// El retorno de carro.

			switch (opc) {
			case 1:
				nuevoContacto(agenda, descifrador);
				break;
			case 2:
				borrarContacto(agenda, descifrador);
				break;
			case 3:
				consultarContacto(agenda, descifrador);
				break;
			case 4:
				listadoContactos(agenda, descifrador);
				break;
			}

		}

		crearFichero(agenda);

		lector.close();
	}

	public static void mostrarMenu() {
		System.out.println("       	AGENDA TELEFÓNICA");
		System.out.println("---------------------------------------");
		System.out.println("1. Añadir nuevo contacto");
		System.out.println("2. Borrar contacto");
		System.out.println("3. Consultar contacto");
		System.out.println("4. Listado de contactos");
		System.out.println("5. Terminar programa");
		System.out.println("---------------------------------------");
		System.out.println("¿Qué opción eliges?");
	}

	public static void nuevoContacto(Agenda agenda, Cipher descifrador) {
		System.out.println("Nombre: ");
		String nombre = lector.nextLine();
		System.out.println("Teléfono: ");
		String tlf = lector.nextLine();
	

		byte[] nombreBytes = nombre.getBytes();
		byte[] tlfBytes = tlf.getBytes();
		
		// Ciframos el nombre y el telefono antes de añadirlo a la agenda.dat
		try {
			descifrador.init(Cipher.ENCRYPT_MODE, agenda.getClave());
			byte[] nombreCifrado = descifrador.doFinal(nombreBytes);
			byte[] tlfCifrado = descifrador.doFinal(tlfBytes);
			agenda.getContactos().add(new Contacto(nombreCifrado, tlfCifrado));
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("El contacto ha sido añadido con éxito");
	}

	public static void borrarContacto(Agenda agenda, Cipher descifrador) {
		int i = 0;
		System.out.println("Nombre que desea eliminar: ");
		String nombre = lector.nextLine();
		String nombreAgenda = new String(agenda.getContactos().get(i).getNombre());
		
		// Ciframos el nombre introducido por el usuario para compararlo con la agenda.
		
		try {
			descifrador.init(Cipher.ENCRYPT_MODE, agenda.getClave());
			byte[] nombreCifrado = descifrador.doFinal(nombre.getBytes());
			descifrador.init(Cipher.DECRYPT_MODE, agenda.getClave());
		while (i < agenda.getContactos().size() &&  !nombreAgenda.equals(new String  (nombreCifrado))) {
			i++;
			nombreAgenda = new String(agenda.getContactos().get(i).getNombre());
			
		}
		if (i == agenda.getContactos().size()) {
			System.out.println("No encontrado");
		} else {
			// Lo descifraremos para mostrar en consola.
			byte[] nombreDescifrado = descifrador.doFinal(agenda.getContactos().get(i).getNombre().getBytes());
			byte[] tlfDescifrado = descifrador.doFinal(agenda.getContactos().get(i).getTelefono().getBytes());
			System.out.println(new String(nombreDescifrado) + "/" + new String(tlfDescifrado)+" se ha eliminado con éxito");
			agenda.getContactos().remove(i);
		}
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void consultarContacto(Agenda agenda, Cipher descifrador) {
		int i = 0;
		System.out.println("Nombre buscado: ");
		String nombre = lector.nextLine();
		String nombreAgenda = new String(agenda.getContactos().get(i).getNombre());
		
		// Cifraremos el nombre introducido por el usuario para compararlo con la agenda.
		
		try {
			descifrador.init(Cipher.ENCRYPT_MODE, agenda.getClave());
			byte[] nombreCifrado = descifrador.doFinal(nombre.getBytes());
			descifrador.init(Cipher.DECRYPT_MODE, agenda.getClave());
			while (i < agenda.getContactos().size() && !new String(nombreAgenda).equals(new String (nombreCifrado))) {
				i++;
				nombreAgenda = new String(agenda.getContactos().get(i).getNombre());
				
			}
			if (i == agenda.getContactos().size()) {
				System.out.println("No encontrado");
			} else {
				// Lo descifraremos para mostrar en consola.
				byte[] nombreDescifrado = descifrador.doFinal(agenda.getContactos().get(i).getNombre().getBytes());
				byte[] tlfDescifrado = descifrador.doFinal(agenda.getContactos().get(i).getTelefono().getBytes());
				System.out.println(new String(nombreDescifrado) + " - " + new String(tlfDescifrado));

			}
			
			
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void listadoContactos(Agenda agenda, Cipher descifrador) {
		for (Contacto c : agenda.getContactos()) {
			// Descifraremos los nombres y teléfonos.
			try {
				descifrador.init(Cipher.DECRYPT_MODE, agenda.getClave());
				byte[] nombreDescifrado = descifrador.doFinal(c.getNombre().getBytes());
				byte[] tlfDescifrado = descifrador.doFinal(c.getTelefono().getBytes());
				System.out.println(new String(nombreDescifrado) + "/" + new String(tlfDescifrado));
			} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	// Realizamos la escritura y lectura del fichero de la agenda.dat
	public static void crearFichero(Agenda agenda) throws IOException {
		FileOutputStream file = new FileOutputStream("agenda.dat");
		ObjectOutputStream buffer = new ObjectOutputStream(file);
		buffer.writeObject(agenda);
		buffer.close();
		file.close();
	}

	public static Agenda leerFichero() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("agenda.dat");
		ObjectInputStream buffer = new ObjectInputStream(file);
		Agenda agenda = (Agenda) buffer.readObject();
		buffer.close();
		file.close();
		return agenda;
	}
}