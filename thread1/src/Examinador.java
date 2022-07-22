
	public class Examinador implements Runnable {
		private Thread hilo;
		BufferExamenes buffer;
		
		public Thread getHilo() {
			return hilo;
		}

		public Examinador(String alumno, BufferExamenes generador) {
			// Construye el hilo. El nombre será el nombre del alumno.

			// Establece el valor de la propiedad buffer 
			hilo = new Thread(this,  alumno);
			this.buffer = generador;
			
			hilo.start();
			
			// Inicia el hilo.

		}
		
		@Override
		public void run() {
			String codigoExamen = this.buffer.consumirExamen();
			if (codigoExamen != null) {
				// Simula aquí un examen de 10 preguntas 
				// cuyas respuestas se seleccionarán al azar
				// entre A, B, C, D o – (sin contestar).
			 
				for (int i=1;i <=10;i++) {
					int azar = (int) (Math.random() * 4);
					if(azar==1) {
						System.out.println(codigoExamen+" "+this.hilo.getName()+" Pregunta "+i +";"+"A");
					}
					if (azar==2){
						System.out.println(codigoExamen+" "+this.hilo.getName()+" Pregunta "+i +";"+"B");
					}
					if (azar==3) {
						System.out.println(codigoExamen+" "+this.hilo.getName()+" Pregunta "+i +";"+"C");
					}
					if(azar==4) {
						System.out.println(codigoExamen+" "+this.hilo.getName()+" Pregunta "+i +";"+"D");
					}
					if(azar==5) {
						System.out.println(codigoExamen+" "+this.hilo.getName()+" Pregunta "+i +";"+"Sin COntestar");
					}
				
				
			else {
			
			}
		}
	}

		}
	}
