
public class Cuento {


String titulo;
String autor;
String recomendadoPara;
// Aquí se indica para que rango de edad está recomendado el cuento.
// 0-1, 1-2, 2-3
public Cuento(String titulo, String autor, String recomendadoPara) {
	super();
	this.titulo = titulo;
	this.autor = autor;
	this.recomendadoPara = recomendadoPara;
}



public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public String getRecomendadoPara() {
	return recomendadoPara;
}
public void setRecomendadoPara(String recomendadoPara) {
	this.recomendadoPara = recomendadoPara;
}

@Override
public String toString() {
	return "Cuento [titulo=" + titulo + ", autor=" + autor + ", recomendadoPara=" + recomendadoPara + "]";
}





}