package servicios;

import java.util.ArrayList;

import modelo.CarritoProductos;
import modelo.Usuario;

public interface AccionesUsuario {

	public String cargarUsuario(Usuario producto);
	
	public String removerUsuario(String usuario);
	
	public String modificarUsuario(String usuario);
	
	public void listarUsuario();
	
	public boolean existeUsuario(String usuario);
	
	public Usuario buscarUsuario(String usuario);
	
	public boolean usuarioInactivo(String usuario, String contrasenia);
	
	public boolean verificarAdmin(String usuario, String contrasenia);
	
	public Usuario verificarUsuario(String usuario, String contrasenia);
	
	public boolean accionesAdmin(String usuario, CarritoProductos carritoAdmin, ArrayList<CarritoProductos> carritosClientes, ArrayList<ArrayList<CarritoProductos>> listaPedidos, AccionesCategoria accionesCategoria, AccionesEmpresa accionesEmpresa);
	
	public boolean accionesCliente(String usuario, CarritoProductos carritoAdmin, CarritoProductos carritoCliente, ArrayList<CarritoProductos> listaPedidos);
}	
