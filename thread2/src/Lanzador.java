
import java.io.File;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessBuilder proceso1, proceso2;
		
		proceso1 = new ProcessBuilder
				("java", "Principal", "Pepe", "Juan", "Luis");
		proceso2 = new ProcessBuilder
				("java", "Principal", "Rosa", "Miguel", "Pedro");

		
		proceso1.redirectError(new File("errores1.txt"));
		proceso1.redirectOutput(new File("examen1.txt"));
		
		
		proceso2.redirectError(new File("errores2.txt"));
		proceso2.redirectOutput(new File("examen2.txt"));
		
		

		
		System.out.println("Se han generado los archivos con éxito");
		
		
		try {
			proceso1.start();
			proceso2.start();
		
			
			System.out.println("El proceso ha sido lanzado con éxito");
			System.out.println("Examina los archivos errores.txt y salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

