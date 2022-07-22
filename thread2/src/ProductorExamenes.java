
import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {
	private BufferExamenes buffer;
	private static int numeroExamen = 0;
	private Thread hilo;
	
	public ProductorExamenes(BufferExamenes buffer) {
		// Incrementa el contador de ex�menes (variable numeroExamen).
		numeroExamen++;
		// Construye el hilo. El nombre ser� la letra E seguida
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
		// Generaci�n del c�digo de examen.
String codigo = this.hilo.getName() + "-" +aa;

// A�ade el nuevo c�digo al buffer de ex�menes.
	buffer.fabricarNuevoExamen(codigo);
	System.out.println("Producido examen: "+ codigo);
// Muestra un mensaje en consola informando sobre el 
// c�digo del examen que se acaba de producir.

	}	
}

