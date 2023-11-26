package com.bd.examen.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.examen.modelo.ClassProducto;
import com.bd.examen.servicios.InterfaceProductoServicio;

@Controller
@RequestMapping("/ControlProducto")
public class ProductoController {
	
	@Autowired
	private InterfaceProductoServicio interfaceproductoservicio;
	
	@GetMapping("/Listar")
		public String ListadoProductos(Model modelo) {
		List<ClassProducto> listado=interfaceproductoservicio.ListadoProductos();		
		modelo.addAttribute("listado", listado);
		return "/Vista/Producto/ListadoProducto";
	}	// FIN DEL METODO LISTAR...
	
	@GetMapping("/Registrar")
	public String RegistrarProducto(Model modelo) {
		ClassProducto clprod = new ClassProducto();
		modelo.addAttribute("regprod", clprod);
		return "Vista/Producto/RegistrarProducto";
	}	// FIN DEL METODO REGISTRAR...
	
	@PostMapping("/Guardar")
	public String GuardarAuto(@ModelAttribute ClassProducto clprod) {
		interfaceproductoservicio.RegistrarProducto(clprod);
		return "redirect:/ControlProducto/Listar";
	}	// FIN DEL METODO GUARDAR...
	
	@GetMapping("/Editar/{id}")
	public String Editar(@PathVariable("id") Integer idprod, Model modelo) {
		ClassProducto clprod = interfaceproductoservicio.BuscarPorId(idprod);
		modelo.addAttribute("regprod", clprod);
		return "Vista/Producto/RegistrarProducto";
	}	// FIN DEL METODO EDITAR...
		
	@GetMapping("/Eliminar/{id}")
	public String Eliminar(@PathVariable("id") Integer idprod, Model modelo) {
		interfaceproductoservicio.EliminarProducto(idprod);
		List<ClassProducto> listado = interfaceproductoservicio.ListadoProductos();
		modelo.addAttribute("listadoproducto", listado);
		return "redirect:/ControlProducto/Listar";
	}	// FIN DEL METODO ELIMINAR...

}
