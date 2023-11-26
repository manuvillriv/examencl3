package com.bd.examen.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.examen.modelo.ClassProducto;
import com.bd.examen.repositorio.InterfaceProducto;

@Service
public class ClassProductoServicioImp implements InterfaceProductoServicio{
	
	@Autowired
	private InterfaceProducto interfaceproducto;

	@Override
	public List<ClassProducto> ListadoProductos() {
		return (List<ClassProducto>) interfaceproducto.findAll();
	}

	@Override
	public void RegistrarProducto(ClassProducto clprod) {
		interfaceproducto.save(clprod);
		
	}

	@Override
	public ClassProducto BuscarPorId(Integer id) {
		return interfaceproducto.findById(id).orElse(null);
	}

	@Override
	public void EliminarProducto(Integer id) {
		interfaceproducto.deleteById(id);
		
	}

}
