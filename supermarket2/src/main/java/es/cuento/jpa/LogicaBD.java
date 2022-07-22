package es.cuento.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.cuento.model.Cuento;
import es.cuento.model.Usuario;

public class LogicaBD {

	private EntityManagerFactory factoria;
	private EntityManager em;

	public LogicaBD() {
		factoria = Persistence.createEntityManagerFactory("supermarket2"); //hay que cambiarlo
		em = factoria.createEntityManager();
	}

	public EntityManager getEm() {
		return em;
	}

	//Todos los cuentos
	public List<Cuento> listaProductos() {
		String sql = "SELECT cue FROM Cuento cue";
		TypedQuery<Cuento> query = em.createQuery(sql, Cuento.class);
		List<Cuento> productos = query.getResultList();
		return productos;
	}
	
	//Cuentos por edad
	public List<Cuento> listaCuentosEdad(String filtro) {
		String sql = "SELECT cue FROM Cuento cue WHERE cue.edad = " + filtro;
		TypedQuery<Cuento> query = em.createQuery(sql, Cuento.class);
		List<Cuento> cuentos = query.getResultList();
		return cuentos;
	}
	
	//Cuentos por temática
	public List<Cuento> listaCuentos(String filtro) {
		String sql = "SELECT cue FROM Cuento cue WHERE cue.tema LIKE '%" + filtro + "%'";
		TypedQuery<Cuento> query = em.createQuery(sql, Cuento.class);
		List<Cuento> cuentos = query.getResultList();
		return cuentos;
	}

	//Inicio sesión
	public List<Usuario> listaUsuarios(String usuario, String pass) {
		String sql = "SELECT usu FROM Usuario usu WHERE usu.correo='" + usuario + "'and usu.password=('" + pass
				+ "')";
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}
	
	//Registrarse
	public void Registrar(String nombre, String apellido, String correo, String password) throws NoSuchAlgorithmException {
	
		em.getTransaction().begin();
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setCorreo(correo);
	     byte[] passwordCifrada = password.getBytes();
	       
	        MessageDigest md = MessageDigest.getInstance("MD5");
	
	        md.update(passwordCifrada);
	       
	     
	        byte[] resumen = md.digest();
	        String str = new String(resumen, java.nio.charset.StandardCharsets.UTF_8);
	        System.out.println(str);
	        // Ejecutamos el método digest para obtener el resumen.
	        u.setPassword(str);
		em.persist(u);
		em.getTransaction().commit();
				
	}

}
