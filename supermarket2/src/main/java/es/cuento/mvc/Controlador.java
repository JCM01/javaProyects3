package es.cuento.mvc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.cuento.jpa.LogicaBD;
import es.cuento.model.Cuento;
import es.cuento.model.Usuario;
import es.cuento.mvc.model.BuscaProducto;
import es.cuento.mvc.model.Login;
import es.cuento.mvc.model.Sesion;


@Controller
public class Controlador {
	private LogicaBD miGestor;
	private Sesion sesion;

	public LogicaBD getMiGestor() {
		return miGestor;
	}

	@Autowired
	@Qualifier("sesion")
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	@Autowired
	@Qualifier("miLogica")
	public void setMiGestor(LogicaBD miGestor) {
		this.miGestor = miGestor;
	}

	public Controlador() {
		super();
	}

	// Inicio
	@RequestMapping("cuentos.html")
	public ModelAndView redireccion1() {
		System.out.println("Pasando por el controlador para resolver cuentos.html");
		ModelAndView mv = new ModelAndView();
		// Mensajes borrados
		mv.addObject("sesion", sesion);
		mv.addObject("login", new Login());
		mv.setViewName("superm");
		return mv;
	}

	// Out
	@RequestMapping("cerrar.html")
	public ModelAndView redireccion2(HttpServletRequest request) {
		System.out.println("Pasando por el controlador para resolver supermercado.html");
		ModelAndView mv = new ModelAndView();
		// Mensajes borrados
		request.getSession().invalidate();
		mv.addObject("sesion", sesion);
		mv.addObject("login", new Login());
		mv.setViewName("superm");
		return mv;
	}

	// Login
	@RequestMapping("login.html")
	public ModelAndView redireccion3(Usuario usuario, Login login) throws NoSuchAlgorithmException {

		System.out.println("Pasando por el controlador para resolver login.html");
		ModelAndView mv = new ModelAndView();
		// Mesajes borrados
		String password=login.getPassword();
		 byte[] passwordCifrada = password.getBytes();
		    MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(passwordCifrada);
	        byte[] resumen = md.digest();
	        String str = new String(resumen, java.nio.charset.StandardCharsets.UTF_8);
	        
	        // Ejecutamos el método digest para obtener el resumen.
	       
	        
		List<Usuario> usuarios = miGestor.listaUsuarios(login.getUser(), str);
		
		System.out.println(usuarios.size());

		if (usuarios.size() == 1) {
			System.out.println(login.getUser());
			sesion.setIniciada(true);
			sesion.setUser(login.getUser());
	        sesion.setPassword(password);
	        mv.setViewName("superm");
	    
		} else {
			mv.setViewName("loginfallo");
		}
		mv.addObject("sesion", sesion);
		mv.addObject("login", login);
		return mv;
	}

	// Registrar
	@RequestMapping("registro.html")
	public void redireccion4(Registro registro) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("registro", new Registro());
		mv.setViewName("superm");
		mv.addObject("sesion", sesion);
		mv.addObject("registro", registro);

	}

	// Registrar 2
	@RequestMapping("registroTotal.html")
	public void redireccion5(Registro registro) throws NoSuchAlgorithmException {
		ModelAndView mv = new ModelAndView();
	
		miGestor.Registrar(registro.getNombre(), registro.getApellidos(), registro.getCorreo(), registro.getPassword());
	}

	// Cuentos Totales
	@RequestMapping("productos.html")
	public ModelAndView redireccion6(BuscaProducto pro) {
		System.out.println("Pasando por el controlador para resolver productos.html");
		ModelAndView mv = new ModelAndView();
		List<Cuento> cuentos = miGestor.listaProductos();
		mv.addObject("cuentos", cuentos);
		mv.addObject("sesion", sesion);
		mv.setViewName("productos");
		return mv;
	}

	// Cuentos Filtro Edad
	@RequestMapping("productos2.html")
	public ModelAndView redireccion7(BuscaProducto pro) {
		System.out.println("Pasando por el controlador para resolver productos.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("filtro", pro.getFiltro());
		List<Cuento> cuentos = miGestor.listaCuentos(pro.getFiltro());
		
		mv.addObject("cuentos", cuentos);
		mv.addObject("sesion", sesion);
		mv.setViewName("productos");
		return mv;
	}
	@RequestMapping("buscaproductos.html")
	public ModelAndView redireccion8() {
		System.out.println("Pasando por el controlador para resolver buscaproductos.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("filtroproducto", new BuscaProducto());
		mv.addObject("filtroCuentoEdad", new BuscaProducto());
		mv.addObject("sesion", sesion);
		mv.setViewName("busqueda");
		return mv;
	}

	// Cuentos Filtro Tema
	@RequestMapping("productos3.html")
	public ModelAndView redireccion10(BuscaProducto pro) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("filtroEdad", pro.getFiltro());
		mv.addObject("filtroCuentoEdad", new BuscaProducto());
		List<Cuento> cuentos = miGestor.listaCuentosEdad(pro.getFiltro());
		mv.addObject("cuentos", cuentos);
		mv.addObject("sesion", sesion);
		mv.setViewName("productos");
		return mv;
	}

	// Política Privacidad
	@RequestMapping("politica.html")
	public ModelAndView redireccion11(BuscaProducto pro) {
		System.out.println("Pasando por el controlador para resolver politica.html");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("politica");
		return mv;
	}

}
