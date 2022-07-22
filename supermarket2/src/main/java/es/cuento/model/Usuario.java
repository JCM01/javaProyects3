package es.cuento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String correo;

	private String apellido;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to Cuento
	@OneToMany(mappedBy="usuario")
	private List<Cuento> cuentos;

	public Usuario() {
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cuento> getCuentos() {
		return this.cuentos;
	}

	public void setCuentos(List<Cuento> cuentos) {
		this.cuentos = cuentos;
	}

	public Cuento addCuento(Cuento cuento) {
		getCuentos().add(cuento);
		cuento.setUsuario(this);

		return cuento;
	}

	public Cuento removeCuento(Cuento cuento) {
		getCuentos().remove(cuento);
		cuento.setUsuario(null);

		return cuento;
	}

}