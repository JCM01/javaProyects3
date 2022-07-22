
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws NotBoundException {
		Registry registry;
		ITestRMI test = null;
		Scanner lector = new Scanner(System.in);
		try {
			/////////////////////////////////////////////////////////////////////////////////
	// obten el objeto remoto y asígnalo a la referencia test declarama más arriba //		
			/////////////////////////////////////////////////////////////////////////////////
			registry = LocateRegistry.getRegistry("192.168.34.41", 5054);
			System.out.println("Hemos obtenido el registro");
			 test = (ITestRMI) registry.lookup("miPregunta");
			System.out.println("Hemos obtenido el objeto remoto");
			System.out.println(); // Retorno de carro.
			

			String opcion;
			do {
				escribirMenu();
				opcion = lector.nextLine().toUpperCase();
				switch (opcion) {
				case "1":
					System.out.println("Prácticar con una pregunta al azar");
					Pregunta p = test.getPregunta();
					String[] respuestas = p.getRespuestas();
					System.out.println(p.getPregunta());
					System.out.println("1. " + respuestas[0]);
					System.out.println("2. " + respuestas[1]);
					System.out.println("3. " + respuestas[2]);
					System.out.println("4. " + respuestas[3]);
					System.out.println("¿Cuál es la respuesta correcta?");
					int correcta = lector.nextInt();
					lector.nextLine(); // Limpiar buffer

					////////////////////////////////////////////////////////////////////////////////
	// Completa para evaluar si la respuesta del usuario es correcta o incorrecta.//
	////////////////////////////////////////////////////////////////////////////////
					int resCorrecta = p.getCorrecta()+1;
					if (resCorrecta == correcta) {
						
						System.out.println("Opción Correcta");
					} 
					else {
						System.out.println("Opción Incorrecta");
					}
					
					break;
				case "2":
					
					/////////////////////////////////////////////////////////////////
	// Completa para examinar al usuario y obtener la calificación //
	// Se utilizará un test con 5 preguntas al azar                //
	/////////////////////////////////////////////////////////////////
					/*
					ArrayList<Pregunta> preguntasAzar = test.get5Azar();
					int notasAzar = 0;
					System.out.println("Prácticar con 5 preguntas al azar");
					for(Pregunta psAzar : preguntasAzar) {
						String[] respuestas2 = psAzar.getRespuestas();
						System.out.println(psAzar.getPregunta());
						System.out.println("1. " + respuestas2[0]);
						System.out.println("2. " + respuestas2[1]);
						System.out.println("3. " + respuestas2[2]);
						System.out.println("4. " + respuestas2[3]);
						System.out.println("¿Cuál es la respuesta correcta?");
						int correcta2 = lector.nextInt();
						lector.nextLine(); // Limpiar buffer
						int resCorrecta2 = psAzar.getCorrecta();
						if(resCorrecta2+1 == correcta2) {
							notasAzar = notasAzar+1;
						}
								
					}
					System.out.println("La nota final que has sacado de 10 preguntas es: "+ notasAzar + "/10");

					
					*/
					
					break;
				case "3":	
					/////////////////////////////////////////////////////////////////
	// Completa para examinar al usuario y obtener la calificación //
	// Se utilizará el test completo                               //
	/////////////////////////////////////////////////////////////////
					ArrayList<Pregunta> preguntas = test.getPreguntas();
					int notas = 0;
					System.out.println("Hacer test completo");
					for(Pregunta ps : preguntas) {
						String[] respuestas3 = ps.getRespuestas();
						System.out.println(ps.getPregunta());
						System.out.println("1. " + respuestas3[0]);
						System.out.println("2. " + respuestas3[1]);
						System.out.println("3. " + respuestas3[2]);
						System.out.println("4. " + respuestas3[3]);
						System.out.println("¿Cuál es la respuesta correcta?");
						int correcta3 = lector.nextInt();
						lector.nextLine(); // Limpiar buffer
						int resCorrecta3 = ps.getCorrecta();
						if(resCorrecta3+1 == correcta3) {
							notas = notas+1;
						}
								
					}
					System.out.println("La nota final que has sacado de 10 preguntas es: "+ notas + "/10");

					break;
				case "4":
					System.out.println("Gracias por utilizar nuestro servicio");
					break;
				default:
					System.out.println("Opción incorrecta");
				}
			} while (!opcion.equals("4"));
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}

	private static void escribirMenu() {
		System.out.println();
		System.out.println("Hacer Test online");
		System.out.println("--------------------------");
		System.out.println("1 = Prácticar con una pregunta al azar");
		System.out.println("2 = Prácticar con 5 preguntas al azar");
		System.out.println("3 = Hacer test completo");
		System.out.println("4 = Finalizar programa");
		System.out.println("--------------------------");
		System.out.println("¿Qué opción eliges?");
	}
}


