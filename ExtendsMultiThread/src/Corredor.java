
public class Corredor extends Thread {

	public Corredor(String nombre, int prioridad) {
		super(nombre);
		this.setPriority(prioridad);
		
		//Lanzamos la tarea invocando al método run()
		this.start();
	
	}

	@Override
	public void run() {
		for (int i=1; i<=10; i++) {
			System.out.println(this.getName() + " va por el kilómetro " + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		System.out.println(this.getName() + " ha llegado a la meta");
	}
	

}
