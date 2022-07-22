package es.supermarket.mvc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.supermarket.jpa.LogicaBD;
import es.supermarket.model.Producto;
import es.supermarket.mvc.model.BuscaProducto;

@Controller
public class Controlador {
	LogicaBD miGestor;
	
	public Controlador() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		miGestor = (LogicaBD) context.getBean("miLogica");
		((ClassPathXmlApplicationContext) context).close();
	}

	@RequestMapping("supermercado.html")
	public ModelAndView redireccion()  {
		System.out.println("Pasando por el controlador para resolver supermercado.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("mensaje1", "Supermercados de la Abuela");
		mv.addObject("mensaje2", "Los mejores productos para usted");
		mv.setViewName("superm");
		return mv;
	}
	
	@RequestMapping("buscaproductos.html")
	public ModelAndView irFormulario() {
		System.out.println("Pasando por el controlador para resolver buscaproductos.html");
		ModelAndView mv = new ModelAndView();
		mv.addObject("filtroproducto", new BuscaProducto());
		// El nuevo objeto BuscaProducto se guardará en command
		// que es el nombre predefinido 
		// para la comunicación MVC entre vista y modelo.
		mv.setViewName("busqueda");
		return mv;
	}

	@RequestMapping(value = "productos.html", method = {RequestMethod.GET, RequestMethod.POST })
	public String agregar(BuscaProducto pro, ModelMap model) {
		System.out.println("Pasando por el controlador para resolver productos.html");
		model.addAttribute("fil", pro.getFiltro());
		
		List<Producto> productos = miGestor.listaProductos(pro.getFiltro());

		model.addAttribute("productos", productos);

		return "productos";
	} 
	
}
