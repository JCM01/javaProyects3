import java.util.HashMap;
import java.util.Map;

public class Escuela {
	Map<String, Alumno> alumnos;
	
	public Escuela(Map<String, Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Escuela() {
		this.alumnos = new HashMap<String, Alumno>();
	}

	public void altaAlumno(Alumno alu) {
		alumnos.put(alu.getNif(), alu);
	}

	public Map<String, Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Map<String, Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
