package es.supermarket.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.supermarket.model.Producto;

public class LogicaBD {
	
	private EntityManagerFactory factoria;
	private EntityManager em;
	
	public LogicaBD() {
		factoria = Persistence.createEntityManagerFactory("supermarket");
		em = factoria.createEntityManager();
	}

	public EntityManager getEm() {
		return em;
	}

	public List<Producto> listaProductos (String filtro) {
		String sql = "SELECT pro FROM Producto pro WHERE pro.nombre LIKE '%"+filtro+"%'";
		TypedQuery<Producto> query = em.createQuery(sql, Producto.class);
		List<Producto> productos = query.getResultList();
		return productos;
	}
}
