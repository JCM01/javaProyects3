
public class Principal {
	public static void main(String[] args) {
		BufferFrases buffer = new BufferFrases();
		new Productor(buffer);
		new Consumidor(buffer);
		new Productor(buffer);
		new Consumidor(buffer);
		new Productor(buffer);
		new Consumidor(buffer);
		new Productor(buffer);
		new Consumidor(buffer);
	}
}

