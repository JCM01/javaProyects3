package es.supermarket.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.supermarket.model.Usuario;

public class LogicaBD {
	
	private EntityManagerFactory factoria;
	private EntityManager em;
	
	public LogicaBD() {
		factoria = Persistence.createEntityManagerFactory("cuentos");
		em = factoria.createEntityManager();
	}

	public EntityManager getEm() {
		return em;
	}

	public List<Usuario> listaProductos (String filtro) {
		String sql = "SELECT pro FROM cuentos.cuento pro WHERE pro.nombre LIKE '%"+filtro+"%'";
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}
}
