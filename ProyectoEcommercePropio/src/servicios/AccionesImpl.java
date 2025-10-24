package servicios;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.CarritoProductos;
import modelo.Producto;

public class AccionesImpl implements Acciones{
	
	private CarritoProductos carro;
	private String mensaje;
	private Scanner scanner;
	
	public AccionesImpl(CarritoProductos carro) {
		super();
		this.carro = carro;
		this.mensaje = "";
		this.scanner = new Scanner(System.in);
	}

	@Override
	public String cargarProducto(Producto producto) {
		if(this.carro.agregarProducto(producto)) {
			this.mensaje = "se agrego correctamente el producto";
		}else {
			this.mensaje = "no se pudo agregar correctamente el producto";
		}
		return mensaje;
	}

	@Override
	public String removerProducto(String codigo) {
		if(existeProducto(codigo)) {
			
			if(this.carro.removerProducto(codigo)) {
				this.mensaje = "se removio correctamente el producto";
			}else {
				this.mensaje = "no se pudo remover el producto";
			}
			
		} else {
			this.mensaje = "el producto no existe";
		}
		
		return mensaje;
	}

	@Override
	public String modificarProducto(String codigo) {
		if(existeProducto(codigo)) {
			
			String nuevoNombre;
			
			System.out.println("ingrese el nuevo nombre del producto: ");

			nuevoNombre = scanner.next(); 
			
			if(this.carro.modificarProducto(codigo, nuevoNombre)){
				
				this.mensaje = "se modifico correctamente el producto";
			}else {
				this.mensaje = "no se pudo modificar el producto";
			}

			scanner.close();
		}else {
			this.mensaje = "no se pudo encontrar el producto a modificar";
		}
		return mensaje;
	}

	@Override
	public void listarProductos() {
		int x = 1;
		ArrayList<Producto> lista = this.carro.getProductos();
		System.out.println("los productos cargados actualmente son: ");
		for (Producto producto : lista) {
			System.out.println("-----------------------------------------");
			System.out.println(x + ":\n");
			System.out.println(producto.toString());
			System.out.println("\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("\n"); 
	}

	@Override
	public boolean existeProducto(String codigo) {
		return this.carro.existeProducto(codigo);
	}

	@Override
	public ArrayList<Producto> buscarProducto(String nombre) {
		return this.carro.buscarProducto(nombre);
	}
	
	

}
