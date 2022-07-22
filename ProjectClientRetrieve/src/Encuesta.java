
import java.io.Serializable;

public class Encuesta implements Serializable {
	private static final long serialVersionUID = -1980426248794531080L;
	
	private int provincia;
	private int sonido;
	private int imagen;
	private int usabilidad;
	
	public Encuesta(int provincia, int sonido, int imagen, int usabilidad) {
		super();
		this.sonido = sonido;
		this.imagen = imagen;
		this.usabilidad = usabilidad;
	}

	public int getProvincia() {
		return provincia;
	}

	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}

	public int getSonido() {
		return sonido;
	}

	public void setSonido(int sonido) {
		this.sonido = sonido;
	}

	public int getImagen() {
		return imagen;
	}

	public void setImagen(int imagen) {
		this.imagen = imagen;
	}

	public int getUsabilidad() {
		return usabilidad;
	}

	public void setUsabilidad(int usabilidad) {
		this.usabilidad = usabilidad;
	}

	@Override
	public String toString() {
		return "Encuesta [provincia=" + provincia + ", sonido=" + sonido + ", imagen=" + imagen + ", usabilidad="+ usabilidad + "]";
	}	
}
