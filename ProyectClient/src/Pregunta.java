import java.io.Serializable;

public class Pregunta implements Serializable {
	private static final long serialVersionUID = -3082161351567390168L;
	private String pregunta;
	private String[] respuestas; // Array con las cuatro respuestas.
	private byte correcta; 
	// Valor del 0 al 3 que indica la respuesta correcta en el array.
	
	public Pregunta(String pregunta, String[] respuestas, byte correcta) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
	}

	public String getPregunta() {
		return pregunta;
	}
	public String[] getRespuestas() {
		return respuestas;
	}
	public byte getCorrecta() {
		return correcta;
	}
}

