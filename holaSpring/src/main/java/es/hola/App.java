package es.hola;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new 
                 ClassPathXmlApplicationContext("context.xml");

		// Creamos una instancia del bean por medio del contexto.
		HolaMundo miBean = (HolaMundo) context.getBean("holita");
		miBean.decirHola();
		((ClassPathXmlApplicationContext) context).close();

	}
}


