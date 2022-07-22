import java.util.LinkedList;
import java.util.Queue;

public class BufferFrases {
	
	private static String frases[] = {
		"El talento es importante, pero son las horas pr�cticas las que marcan la diferencia",
		"Piensa si donde vas ahora te acerca a donde quieres estar ma�ana",
		"Cuando tu mente est� confundida tu coraz�n sabe la respuesta",
		"Lo que m�s mala suerte da es ser supersticioso",
		"La suerte es lo que sucede cuando la preparaci�n se encuentra con la oportunidad",
		"La suerte es tenacidad en conseguir tu prop�sito",
		"Suerte a menudo puede significar simplemente aprovechar una situaci�n en el momento adecuado",
		"Una acci�n vale m�s que todo un mundo de promesas",
		"Si buscas resultados distintos, no hagas siempre lo mismo",
		"Una pi�a y un Mario Bros os acompa�an en vuestras andanzas"
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

