package com.bd.examen.servicios;

import java.util.List;

import com.bd.examen.modelo.ClassProducto;

public interface InterfaceProductoServicio {
	
	public List<ClassProducto> ListadoProductos();
	public void RegistrarProducto(ClassProducto clprod);
	public ClassProducto BuscarPorId(Integer id);
	public void EliminarProducto(Integer id);

}
