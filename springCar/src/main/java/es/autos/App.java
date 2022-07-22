package es.autos;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
 
		Vehiculo vehiculo = (Vehiculo) (context.getBean("vehiculo"));
 
		System.out.println(vehiculo.comprobarMotor());
		System.out.println("Vehiculo marca: " + vehiculo.getMarca());
		System.out.println("Vehiculo modelo: " + vehiculo.getModelo());
 
		((ClassPathXmlApplicationContext) context).close();
 
    }
}
