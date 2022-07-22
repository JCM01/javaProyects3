import java.util.LinkedList;
import java.util.Queue;

public class BufferFrases {
	
	private static String frases[] = {
		"El talento es importante, pero son las horas prácticas las que marcan la diferencia",
		"Piensa si donde vas ahora te acerca a donde quieres estar mañana",
		"Cuando tu mente está confundida tu corazón sabe la respuesta",
		"Lo que más mala suerte da es ser supersticioso",
		"La suerte es lo que sucede cuando la preparación se encuentra con la oportunidad",
		"La suerte es tenacidad en conseguir tu propósito",
		"Suerte a menudo puede significar simplemente aprovechar una situación en el momento adecuado",
		"Una acción vale más que todo un mundo de promesas",
		"Si buscas resultados distintos, no hagas siempre lo mismo",
		"Una piña y un Mario Bros os acompañan en vuestras andanzas"
	};
	
	private Queue<String> cola;

	public BufferFrases() {
		cola = new LinkedList<String>();
	}
	
	public synchronized void poner() {
		int azar = (int) (Math.random() * 10);
		cola.add(azar + " - " + frases[azar]);
		notify();
	}

	public synchronized String sacar() {
		int esperas = 0;
		while (cola.isEmpty() && esperas<30) {
			esperas++;
			try {
				wait(10);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		if (esperas<30) {
			String frase = cola.remove();
			return frase;
		} else {
			return null;
		}
	}

	
}

