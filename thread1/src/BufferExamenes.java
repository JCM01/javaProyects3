
import java.util.LinkedList;
import java.util.Queue;

public class BufferExamenes {
	
	private Queue<String> colaExamenes;
	
	public BufferExamenes() {
		colaExamenes = new LinkedList<String>();
	}
	
	public synchronized void fabricarNuevoExamen(String codigo) {
		// Aqu� se fabrica un nuevo examen.
		// Un hilo de la clase ProductorExamenes 
		// se encargar� de fabricarlo
		// y pasarlo como argumento a este m�todo.
		colaExamenes.add(codigo);
		notify();

		// A�ade el c�digo pasado como argumento a la cola
		// y libera el hilo que est� intentando consumir 
		// un nuevo examen.
	}

	public synchronized String consumirExamen() {
		// Este m�todo se encargar� de suministrar un examen
		// a cada hilo de tipo Examinador que lo solicite.
		int esperas = 0;
		while (colaExamenes.isEmpty() && esperas<30) {
			esperas++;
			try {
				wait(10);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		// Para suministrar el examen habr� antes que esperar
		// hasta que haya alg�n examen para consumir en la cola.

		// Haz aqu� una pausa hasta que se haya fabricado alg�n examen.
		
		// Si la cola sigue sin estar vac�a, saca un examen y 
		// entr�galo como retorno de esta funci�n.
		
		if (esperas<30) {
			String frase = colaExamenes.remove();
			return frase;
		} else {
			return null;
		}
	}
}

