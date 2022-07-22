import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cliente {
	private static ArrayList<Encuesta> encuestas;

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(" APLICACIÓN CLIENTE GESTIÓN DE ENCUESTAS");
		System.out.println("-------------------------------------------");
		Scanner lector = new Scanner(System.in);

		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("192.168.34.41", 2000);
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			// Conectamos con el servidor.
			System.out.println("Comunicación establecida con el servidor");
			
			
			//Aqui es el flujo de entrada y salida de datos de las peticiones de los clientes 
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
			
			//Se crea un arraylist de encuesta para almacenar los datos y aqui es donde se lee los objetos de entrada. 
			encuestas = (ArrayList<Encuesta>) entrada.readObject();
			
			entrada.close();
			salida.close();
			cliente.close();
		} catch (IOException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
			lector.close();
			return;
		}

		String peticion = "";
		while (!peticion.equals("5")) {
			System.out.println("1. Mostrar todas las encuestas");
			System.out.println("2. Mostrar encuestas de una provincia");
			System.out.println("3. Mostrar media valoraciones de sonido, imagen e usabiliad");
			System.out.println("4. Mostrar media valoraciones de sonido, imagen e usabiliad de una provincia");
			System.out.println("5. Finalizar programa");
			System.out.println("¿Qué opción eliges (1-5)?");
			peticion = lector.nextLine();

			switch (peticion) {
			case "1":
				
				int img1 = 0;
				int so1 = 0;
				int usa1 = 0;
				int total1 = 0;
				
				Iterator<Encuesta> MostrarIterator = encuestas.iterator();
				while(MostrarIterator.hasNext()){
					
					Encuesta e = MostrarIterator.next();
					
					img1 = e.getImagen();
					so1 = e.getSonido();
					usa1 = e.getUsabilidad();
					
					total1 = so1+img1+usa1;
					
					System.out.print(e + " media= " + total1/3 +"\n");
					
					
				}
				break;
		
			
			case "2":
				int img2 = 0;
				int so2 = 0;
				int usa2 = 0;
				int total2 = 0;
				
				System.out.println("Escoge un número del 1 al 52");
				
				int encue = lector.nextInt();
				lector.nextLine();
				Iterator<Encuesta> provinciasIterator = encuestas.iterator();				
				while(provinciasIterator.hasNext()){
					
					Encuesta e = provinciasIterator.next();
					
					img2 = e.getImagen();
					so2 = e.getSonido();
					usa2 = e.getUsabilidad();
					
					total2 = so2+img2+usa2;
					
					
					if(e.getProvincia()== encue) {
						System.out.print(e + " media= " + total2/3 +"\n");

					}
				}				
				break;
				
			case "3":
				Iterator<Encuesta> mediaIterator = encuestas.iterator();
				
				float img3 = 0;
				float usa3 = 0;
				float so3 = 0;
				
				for(Encuesta encuesta : encuestas) {
					
					img3 = img3 + encuesta.getImagen();
					usa3 = usa3 + encuesta.getUsabilidad();
					so3 = so3 + encuesta.getSonido();
				}
				
				int SumaEncuestas = encuestas.size();
				System.out.println("Media de imagen: "+img3/SumaEncuestas);
				System.out.println("Media de sonido: "+so3/SumaEncuestas);
				System.out.println("Media de usabilidad: "+usa3/SumaEncuestas);
				
				break;

			case "4":
			case "5":
			default:
			}
			System.out.println();
			System.out.println();
		}
		lector.close();
	}
}

