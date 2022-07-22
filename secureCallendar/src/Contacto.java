import java.io.Serializable;

public class Contacto implements Serializable {
	private static final long serialVersionUID = 6114764564160585872L;

	private byte[] nombre;
	private byte[] telefono;

	public Contacto(byte[] nombre, byte[] telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return new String(nombre);
	}

	public String getTelefono() {
		return new String(telefono);
	}

	@Override
	public String toString() {
		return "Contacto [" + new String(nombre) + " - " + new String(telefono) + "]";
	}
}