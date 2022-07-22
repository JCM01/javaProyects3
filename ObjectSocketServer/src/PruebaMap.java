
public class PruebaMap {
	public static void main(String[] args) {
		Escuela escuela = new Escuela();
		escuela.altaAlumno(new Alumno("11111111A", "Pedro Torres", 18));
		escuela.altaAlumno(new Alumno("22222222B", "Luis Maldonado", 23));
		escuela.altaAlumno(new Alumno("33333333C", "Alicia Pérez", 17));
		
		escuela.getAlumnos().get("11111111A").calificar("Matemáticas", 10);
		escuela.getAlumnos().get("11111111A").calificar("Inglés", 8);
		escuela.getAlumnos().get("11111111A").calificar("Lengua", 3);
		
		escuela.getAlumnos().get("22222222B").calificar("Matemáticas", 3);
		escuela.getAlumnos().get("22222222B").calificar("Inglés", 4);
		escuela.getAlumnos().get("22222222B").calificar("Lengua", 7);
		
		escuela.getAlumnos().get("33333333C").calificar("Matemáticas", 7);
		escuela.getAlumnos().get("33333333C").calificar("Inglés", 3);
		escuela.getAlumnos().get("33333333C").calificar("Lengua", 9);
		
		Alumno alu = escuela.getAlumnos().get("33333333C");
		System.out.println(alu);
		alu = escuela.getAlumnos().get("44444444D");
		System.out.println(alu);
	}
}
