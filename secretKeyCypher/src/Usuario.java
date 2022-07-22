import java.io.Serializable;
import java.util.ArrayList;

import javax.crypto.SecretKey;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 4391367156278745898L;
private String user;
private String password;
private ArrayList<Cuento> recomendaciones;

 
// Relación de cuentos que recomienda este usuario.

public Usuario(String user, String password) {
	super();
	this.user = user;
	this.password = password;
	this.recomendaciones = new ArrayList<Cuento>();
		
}
private SecretKey clave;
public SecretKey getClave() {
	return clave;
}
public void setClave(SecretKey clave) {
	this.clave=clave;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public ArrayList<Cuento> getRecomendaciones() {
	return recomendaciones;
}

public void setRecomendaciones(ArrayList<Cuento> recomendaciones) {
	this.recomendaciones = recomendaciones;
}

@Override
public String toString() {
	return "Usuario [user=" + user + ", password=" + password + ", recomendaciones=" + recomendaciones + "]";
}

public void add(String titulo, String autor, String edad) {
	// TODO Auto-generated method stub
	this.recomendaciones.add(new Cuento(titulo, autor, edad));
}




}