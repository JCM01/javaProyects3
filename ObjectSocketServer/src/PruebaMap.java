
public class PruebaMap {
	public static void main(String[] args) {
		Escuela escuela = new Escuela();
		escuela.altaAlumno(new Alumno("11111111A", "Pedro Torres", 18));
		escuela.altaAlumno(new Alumno("22222222B", "Luis Maldonado", 23));
		escuela.altaAlumno(new Alumno("33333333C", "Alicia P�rez", 17));
		
		escuela.getAlumnos().get("11111111A").calificar("Matem�ticas", 10);
		escuela.getAlumnos().get("11111111A").calificar("Ingl�s", 8);
		escuela.getAlumnos().get("11111111A").calificar("Lengua", 3);
		
		escuela.getAlumnos().get("22222222B").calificar("Matem�ticas", 3);
		escuela.getAlumnos().get("22222222B").calificar("Ingl�s", 4);
		escuela.getAlumnos().get("22222222B").calificar("Lengua", 7);
		
		escuela.getAlumnos().get("33333333C").calificar("Matem�ticas", 7);
		escuela.getAlumnos().get("33333333C").calificar("Ingl�s", 3);
		escuela.getAlumnos().get("33333333C").calificar("Lengua", 9);
		
		Alumno alu = escuela.getAlumnos().get("33333333C");
		System.out.println(alu);
		alu = escuela.getAlumnos().get("44444444D");
		System.out.println(alu);
	}
}
