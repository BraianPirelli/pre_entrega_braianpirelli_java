package modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import util.Descontable;

public class CarritoProductos implements Descontable{
	private ArrayList<Producto> productos;
	private double valorTotal;
	private double valorAPagar;
	
	public CarritoProductos() {
		super();
		this.productos = new ArrayList<Producto>();
		
		LocalDate localfecha = LocalDate.now();	
		java.time.Instant instant = localfecha.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Date fecha = Date.from(instant);
		
		productos.add(new Producto("123", "pan", 10.5, fecha, new Categoria("panaderia", "panificados"), new Empresa("bimbo", "enterprise"), 10));
		productos.add(new Producto("456", "leche", 11.5, fecha, new Categoria("fresco", "lacteos"), new Empresa("tserenisima", "enterprise"), 10));
		productos.add(new Producto("789", "azucar", 12.5, fecha, new Categoria("almacen", "mesa"), new Empresa("estrella", "enterprise"), 10));
		productos.add(new Producto("987", "aceite",13.5, fecha, new Categoria("almacen", "mesa"), new Empresa("cañuelas", "enterprise"), 10));
		productos.add(new Producto("654", "yerba", 14.5, fecha, new Categoria("almacen", "mesa"), new Empresa("taragui", "enterprise"), 10));
		productos.add(new Producto("321", "jabon", 15.5, fecha, new Categoria("higiene", "limpieza"), new Empresa("dove", "enterprise"), 10));
		
		this.valorTotal = getValorTotal();
		this.valorAPagar = 0;
	} 
	
	public CarritoProductos(String vacio) {
		super();
		this.productos = new ArrayList<Producto>();
		this.valorTotal = getValorTotal();
		this.valorAPagar = 0;
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> vacio){
		this.productos = vacio;
	}
	
	public double getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	public double getValorTotal() {
		calculoTotal();
		return valorTotal;
	}
	private void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	private void calculoTotal() {
		double aux = 0;
		if(productos.size() > 0) {
			for (Producto producto : productos) {
				aux += producto.getPrecio();
			}
		}
		setValorTotal(aux);
	}

	public boolean agregarProducto(Producto producto) {
		return this.productos.add(producto); 
	}
	
	public boolean removerProducto(String codigo) {
		int x = 0;
		for (Producto producto : this.productos) {
			if(producto.getCodigo().equals(codigo)){
				producto.setEstado(false);
				this.productos.set(x, producto);
				return true;
			}
			x++;
		} 
		return false;
	} 
	
	public boolean modificarProducto(String codigo, String nombreNuevo) {
		int x = 0;
		if(nombreNuevo.isEmpty()) {
			return false;
		}
		
		for (Producto producto : productos) {
			if(producto.getCodigo().equals(codigo)) {
				producto.setNombre(nombreNuevo);
				productos.set(x, producto);
				return true;
			}
			x++;
		}
		return false;
	}
	public boolean modificarProducto(String codigo, double precioNuevo) {
		int x = 0;
		if(precioNuevo <= 0) {
			return false;
		}
		
		for (Producto producto : productos) {
			if(producto.getCodigo().equals(codigo)) {
				producto.setPrecio(precioNuevo);
				productos.set(x, producto);
				return true;
			}
			x++;
		}
		return false;
	}
	public boolean modificarProducto(String codigo, int stockNuevo) {
		int x = 0;
		
		if(stockNuevo < 0) {
			return false;
		}
		
		for (Producto producto : productos) {
			if(producto.getCodigo().equals(codigo)) {
				producto.setStock(stockNuevo);
				productos.set(x, producto);
				return true;
			}
			x++;
		}
		return false;
	}
	
	public boolean existeProducto(String codigo) {
		for (Producto producto : this.productos) {
			if(producto.getCodigo().equals(codigo)){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Producto> buscarProducto(String nombre) {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		for (Producto producto : this.productos) {
			if(producto.getNombre().equals(nombre) && producto.isEstado()) {
				lista.add(producto);
			}
		}
		return lista;
	}

	@Override
	public double calcularDescuento() {
		if(getProductos().size() > 10) {
			System.out.println("dada la cantidad de productos, realizo una compra mayorista y obtuvo un descuento de 10%");
			setValorAPagar(getValorTotal() - (getValorTotal() * 0.1));
			return getValorTotal() * 0.1;
		}
		System.out.println("dada la cantidad de productos, realizo una compra minorista y no obtuvo ningun descuento");
		setValorAPagar(getValorTotal());
		return getValorTotal();
	}
}
