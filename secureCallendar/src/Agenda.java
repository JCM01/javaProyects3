import java.io.Serializable;
import java.util.ArrayList;

import javax.crypto.SecretKey;

public class Agenda implements Serializable {
	private static final long serialVersionUID = 1324774912528254307L;

	private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	private SecretKey clave;

	public SecretKey getClave() {
		return clave;
	}

	public void setClave(SecretKey clave) {
		this.clave = clave;
	}

	public Agenda() {
		this.contactos = new ArrayList<Contacto>();
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}
}