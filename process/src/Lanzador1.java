import java.io.File;
import java.io.IOException;

public class Lanzador1 {

	public static void main(String[] args) {
ProcessBuilder proceso1, proceso2, proceso3;
		
		proceso1 = new ProcessBuilder("java", "Triangulo", "5");
		proceso2 = new ProcessBuilder("java", "Triangulo", "7");
		proceso3 = new ProcessBuilder("java", "Triangulo", "9");
		
		proceso1.redirectError(new File("errores1.txt"));
		proceso1.redirectOutput(new File("triangulo5.txt"));
		
		
		proceso2.redirectError(new File("errores2.txt"));
		proceso2.redirectOutput(new File("triangulo7.txt"));
		
		
		proceso3.redirectError(new File("errores3.txt"));
		proceso3.redirectOutput(new File("triangulo9.txt"));
	
		
		try {
			proceso1.start();
			proceso2.start();
			proceso3.start();
			
			System.out.println("El proceso ha sido lanzado con éxito");
			System.out.println("Examina los archivos errores.txt y salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
