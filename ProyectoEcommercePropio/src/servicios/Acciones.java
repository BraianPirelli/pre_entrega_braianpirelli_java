package servicios;

import java.util.ArrayList;

import modelo.Producto;

public interface Acciones {

	public String cargarProducto(Producto producto);
	
	public String removerProducto(String codigo);
	
	public String modificarProducto(String codigo);
	
	public void listarProductos();
	
	public boolean existeProducto(String codigo);
	
	public ArrayList<Producto> buscarProducto(String nombre);
}
