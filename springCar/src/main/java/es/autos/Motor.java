package es.autos;

import org.springframework.stereotype.Service;

@Service
public class Motor {
	private String tipo; // Diesel, gasolina, etc.
	private int caballos;
	
	public Motor() {
		this.tipo = "Gasolina";
		this.caballos = 100;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCaballos() {
		return caballos;
	}
	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
}
