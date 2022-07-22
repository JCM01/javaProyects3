package es.cuento.mvc.model;

public class Sesion {
	
	private String user;
	private String password;
	private boolean iniciada;
	
	public Sesion() {
		super();
		this.user = "";
		this.password = "";
		this.iniciada = false;
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
	public boolean isIniciada() {
		return iniciada;
	}
	public void setIniciada(boolean iniciada) {
		this.iniciada = iniciada;
	}
}
