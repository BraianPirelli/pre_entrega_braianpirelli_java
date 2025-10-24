package modelo;

import java.util.Date;

public class Pintura extends Producto{
	private String color;
	private double densidad;
	
	public Pintura(String codigo, String nombre, double precio, Date vencimiento, Categoria categoria, Empresa empresa, int stock, String color, double densidad) {
		super(codigo, nombre, precio, vencimiento, categoria, empresa, stock);
		this.color = color;
		this.densidad = densidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}

	@Override
	public String toString() {
		return "Pintura color=" + color + ", densidad=" + densidad + " " + super.toString();
	}
	
	
}
