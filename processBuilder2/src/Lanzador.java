import java.io.File;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException {
		ProcessBuilder proceso1, proceso2;
		
		proceso1 = new ProcessBuilder("java", "Principal");
		proceso2 = new ProcessBuilder("java", "Principal");
		
		proceso1.redirectError(new File("errores1.txt"));
		proceso1.redirectOutput(new File("salida1.txt"));
		proceso1.redirectInput(new File("entrada1.txt"));
		proceso2.redirectError(new File("errores2.txt"));
		proceso2.redirectOutput(new File("salida2.txt"));
		proceso2.redirectInput(new File("entrada2.txt"));
		try {
			proceso1.start().waitFor();
			proceso2.start().waitFor();
			
			System.out.println("El proceso ha sido lanzado con éxito");
			System.out.println("Examina los archivos errores.txt y salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		/*ProcessBuilder proceso;
		
		// A ProcessBuilder le pasamos los mismos argumentos
		// que palabras tengo que escribir en la línea de comandos
		proceso = new ProcessBuilder("java", "Principal");
		proceso.redirectError(new File("errores.txt"));
		proceso.redirectOutput(new File("salida.txt"));
		proceso.redirectInput(new File("entrada.txt"));
		try {
			proceso.start();
			System.out.println("El proceso ha sido lanzado con éxito");
			System.out.println
("Examina los archivos errores.txt y salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
}
*/
	}
		
	}

