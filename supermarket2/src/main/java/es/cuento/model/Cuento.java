package es.cuento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuento database table.
 * 
 */
@Entity
@NamedQuery(name="Cuento.findAll", query="SELECT c FROM Cuento c")
public class Cuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String autor;

	private int edad;

	@Lob
	private String editorial;

	@Lob
	private String imagen;

	@Lob
	private String nombre;

	@Lob
	private String sinopsis;

	@Lob
	private String tema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="CORREO")
	private Usuario usuario;

	public Cuento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}