
import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {
	private BufferExamenes buffer;
	private static int numeroExamen = 0;
	private Thread hilo;
	
	public ProductorExamenes(BufferExamenes buffer) {
		// Incrementa el contador de exámenes (variable numeroExamen).
		numeroExamen++;
		// Construye el hilo. El nombre será la letra E seguida
		// del valor de la variable numeroExamen.
		hilo = new Thread(this, "E" + numeroExamen);
		// Establece el valor de la propiedad buffer 
		this.buffer = buffer;
		// Inicia el hilo.
		hilo.start();
		}

	@Override
	public void run() {
		int aa = LocalDateTime.now().getYear();
		// Generación del código de examen.
String codigo = this.hilo.getName() + "-" +aa;

// Añade el nuevo código al buffer de exámenes.
	buffer.fabricarNuevoExamen(codigo);
	System.out.println("Producido examen: "+ codigo);
// Muestra un mensaje en consola informando sobre el 
// código del examen que se acaba de producir.

	}	
}

