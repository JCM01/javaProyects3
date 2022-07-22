
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TestRMI extends UnicastRemoteObject implements ITestRMI {

	private static final long serialVersionUID = 4044509548496761475L;
	ArrayList<Pregunta> preguntas;
	
	public TestRMI() throws RemoteException {
		super();
		this.preguntas = new ArrayList<Pregunta>();
		cargarTest();
	}	
	public TestRMI(ArrayList<Pregunta> preguntas) throws RemoteException {
		super();
		this.preguntas = preguntas;
	}
	
	private void cargarTest() throws RemoteException {
		String pregunta;
		byte correcta;
		
		// Pregunta 1
		pregunta = "Los protocolos TCP y UDP se situán…";
		String[] respuestas1 = new String[4];
		respuestas1[0] = "En la capa de acceso al medio de la pila IP.";
		respuestas1[1] = "En la capa de internet de la pila IP.";
		respuestas1[2] = "En la capa de aplicación de la pila IP.";
		respuestas1[3] = "En la capa de transporte de la pila IP.";
		correcta = 3;
		this.preguntas.add(new Pregunta(pregunta, respuestas1, correcta));
		
		// Pregunta 2
		pregunta = "El protocolo UDP…";
		String[] respuestas2 = new String[4];
		respuestas2[0] = "Es más lento del protocolo TCP.";
		respuestas2[1] = "Es más rápido que el protocolo TCP.";
		respuestas2[2] = "Está orientado a conexión.";
		respuestas2[3] = "Es válido para las aplicaciones cliente/servidor.";
		correcta = 1;
		this.preguntas.add(new Pregunta(pregunta, respuestas2, correcta));
		
		// Pregunta 3
		pregunta = "Todo proceso de comunicación entre dos programas consta de los siguientes elementos:";
		String[] respuestas3 = new String[4];
		respuestas3[0] = "Mensaje, receptor, paquete, canal de comunicación, protocolo.";
		respuestas3[1] = "Emisor, receptor, paquete, canal de comunicación, protocolo de comunicaciones.";
		respuestas3[2] = "Mensaje, emisor, receptor, paquete, canal de comunicación, protocolo de comunicaciones.";
		respuestas3[3] = "Mensaje, emisor, paquete, canal de comunicación, protocolo de comunicaciones.";
		correcta = 2;
		this.preguntas.add(new Pregunta(pregunta, respuestas3, correcta));
		
		// Pregunta 4
		pregunta = "El método accept() de la clase ServerSocket retorna un objeto…";
		String[] respuestas4 = new String[4];
		respuestas4[0] = "De tipo Socket que nos suministra un enchufe al cliente.";
		respuestas4[1] = "De tipo InputStream para leer el mensaje del cliente.";
		respuestas4[2] = "De tipo OutputStream para escribir un mensaje al cliente.";
		respuestas4[3] = "De tipo InputOutputStream para comunicar servidor con cliente.";
		correcta = 0;
		this.preguntas.add(new Pregunta(pregunta, respuestas4, correcta));
		
		// Pregunta 5
		pregunta = "A partir de sockets streams cliente y servidor pueden enviarse.";
		String[] respuestas5 = new String[4];
		respuestas5[0] = "Todo tipo de objetos.";
		respuestas5[1] = "Exclusivamente textos.";
		respuestas5[2] = "Exclusivamente grupos de bytes.";
		respuestas5[3] = "Exclusivamente números.";
		correcta = 0;
		this.preguntas.add(new Pregunta(pregunta, respuestas5, correcta));

		// Pregunta 6
		pregunta = "¿Cuál de los siguientes métodos pertenece a la clase Socket?";
		String[] respuestas6 = new String[4];
		respuestas6[0] = "accept().";
		respuestas6[1] = "wait().";
		respuestas6[2] = "connect().";
		respuestas6[3] = "read().";
		correcta = 2;
		this.preguntas.add(new Pregunta(pregunta, respuestas6, correcta));
		
		// Pregunta 7
		pregunta = "¿Cuál de los siguientes métodos pertenece a la clase ServerSocket?";
		String[] respuestas7 = new String[4];
		respuestas7[0] = "accept().";
		respuestas7[1] = "wait().";
		respuestas7[2] = "connect().";
		respuestas7[3] = "read().";
		correcta = 0;
		this.preguntas.add(new Pregunta(pregunta, respuestas7, correcta));
		
		// Pregunta 8
		pregunta = "Para atender múltiples peticiones de clientes simultáneamente, un objeto ServerSocket necesita…";
		String[] respuestas8 = new String[4];
		respuestas8[0] = "Guardar cada petición en un elemento de una colección.";
		respuestas8[1] = "Atender cada petición en un hilo independiente.";
		respuestas8[2] = "Guardar cada petición en un array.";
		respuestas8[3] = "Nada en especial, los ServerSockets son multitarea sin necesidad de que el programador tenga que gestionarlo.";
		correcta = 1;
		this.preguntas.add(new Pregunta(pregunta, respuestas8, correcta));
		
		// Pregunta 9
		pregunta = "Canal de comunicación es sinónimo de…";
		String[] respuestas9 = new String[4];
		respuestas9[0] = "Flujo o stream.";
		respuestas9[1] = "Puerto de comunicación.";
		respuestas9[2] = "Fichero de datos de salida.";
		respuestas9[3] = "Fichero de datos de entrada.";
		correcta = 0;
		this.preguntas.add(new Pregunta(pregunta, respuestas9, correcta));
		
		// Pregunta 10
		pregunta = "La clase InetSocketAddress representa…";
		String[] respuestas10 = new String[4];
		respuestas10[0] = "Una dirección IP.";
		respuestas10[1] = "Un puerto.";
		respuestas10[2] = "Una dirección IP y un puerto.";
		respuestas10[3] = "Un router.";
		correcta = 2;
		this.preguntas.add(new Pregunta(pregunta, respuestas10, correcta));
	}
	
	@Override
	public ArrayList<Pregunta> getPreguntas() throws RemoteException {
		// Retorna el test completo.
		return this.preguntas;
	} 
	@Override
	public Pregunta getPregunta() throws RemoteException {
		// Retorna una pregunta al azar.
		byte azar = (byte) (Math.random()*10);
		return this.preguntas.get(azar);
	} 
	@Override
	public ArrayList<Pregunta> get5Azar() throws RemoteException {
		ArrayList<Pregunta> preguntas5 = new ArrayList<Pregunta>();
		
		//////////////////////////////////////////////////////////////////////////////
		// Carga el objeto preguntas5 con con 5 preguntas al azar que no se repitan.//
		//////////////////////////////////////////////////////////////////////////////
		return preguntas5;
	} 
}
