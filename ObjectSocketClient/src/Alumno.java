import java.io.Serializable;
import java.util.ArrayList;
 
public class Alumno implements Serializable {
	private static final long serialVersionUID = 4854486451470258537L;
	private String nif;
	private String nombre;
	private int edad;
	private ArrayList<Calificacion> calificaciones;
	
	public Alumno(String nif, String nombre, int edad) {
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
		this.calificaciones = new ArrayList<Calificacion>();
	}
	public void calificar(String asignatura, int nota) {
		this.calificaciones.add(new Calificacion(asignatura, nota));
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
