package es.supermarket.mvc.model;

public class BuscaProducto {
	private String filtro;

	public BuscaProducto() {
		super();
		this.filtro = "A"; // Filtro predeterminado.
	}

	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
