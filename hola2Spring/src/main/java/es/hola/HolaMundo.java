package es.hola;


import org.springframework.stereotype.Service;

@Service("holita")
public class HolaMundo {
	public void decirHola() {
		System.out.println("Hola mundo desde el Spring con anotaciones");
	}
}


