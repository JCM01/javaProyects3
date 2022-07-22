import java.time.LocalDateTime;

public class Triangulo {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Se requiere un argumento");
			return;
		}
		int filas = Integer.parseInt(args[0]);
		System.out.println(LocalDateTime.now());
		for (int i=filas; i>=1; i--) {
			for (int n=1; n<=i; n++) {
				System.out.print(n);
			}
			System.out.println();
		}
		System.out.println(LocalDateTime.now());
	}
}

