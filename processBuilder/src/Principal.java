import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		ProcessBuilder proceso;
		proceso = new ProcessBuilder("C:/Windows/notepad.exe", "cine.txt");
		
		Process p;
		try {
			proceso.directory(new File("C:\\jose"));
			p = proceso.start();
			
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("Un error");
		} 
		
		System.out.println("Hola Caracola");
		
		

		
		
		
		

	}

}
