package es.supermarket.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.supermarket.jpa.LogicaBD;
import es.supermarket.model.Usuario;
import es.supermarket.mvc.model.BuscaProducto;
import es.supermarket.mvc.model.Login;
import es.supermarket.mvc.model.Sesion;

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

	@RequestMapping("supermercado.html")
	public ModelAndView redireccion1()  {
		System.out.println("Pasando por el controlador para resolver supermercado.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("mensaje1", "Supermercados de la Abuela");
		mv.addObject("mensaje2", "Los mejores productos para usted");
		mv.addObject("sesion", sesion);
		mv.addObject("login", new Login());
		mv.setViewName("superm");
		return mv;
	}
	@RequestMapping("cerrar.html")
	public ModelAndView redireccion7(HttpServletRequest request)  {
		System.out.println("Pasando por el controlador para resolver supermercado.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("mensaje1", "Supermercados de la Abuela");
		mv.addObject("mensaje2", "Los mejores productos para usted");
		request.getSession().invalidate();
		mv.addObject("sesion", sesion);
		mv.addObject("login", new Login());
		mv.setViewName("superm");
		return mv;
	}
	@RequestMapping("login.html")
	public ModelAndView redireccion2(Login login)  {
		System.out.println("Pasando por el controlador para resolver login.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("mensaje1", "Supermercados de la Abuela");
		mv.addObject("mensaje2", "Los mejores productos para usted");
		if (login.getUser().equals("Perico") && login.getPassword().equals("Palotes")) {
			sesion.setIniciada(true);
			sesion.setUser(login.getUser());
			sesion.setPassword(login.getPassword());
			mv.setViewName("superm");
		}
		else {
			mv.setViewName("loginfallo");
		}
		mv.addObject("sesion", sesion);
		mv.addObject("login", login);
		return mv;
	}
	
	@RequestMapping("buscaproductos.html")
	public ModelAndView redireccion3() {
		System.out.println("Pasando por el controlador para resolver buscaproductos.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("filtroproducto", new BuscaProducto());
		mv.addObject("sesion", sesion);
		mv.setViewName("busqueda");
		return mv;
	}

	@RequestMapping("productos.html")
	public ModelAndView redireccion4(BuscaProducto pro) {
		System.out.println("Pasando por el controlador para resolver productos.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("fil", pro.getFiltro());
		List<Usuario> usuarios = miGestor.listaProductos(pro.getFiltro());
		mv.addObject("productos", usuarios);
		mv.addObject("sesion", sesion);
		mv.setViewName("productos");
		return mv;
	}
}
