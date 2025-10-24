package modelo;

import java.util.Date;

public class Perfume extends Producto{
	private String fragancia;
	private double cantidad;
	private String paisOrigen;
	
	public Perfume(String codigo, String nombre, double precio, Date vencimiento, Categoria categoria, Empresa empresa, int stock, String fragancia, double cantidad, String paisOrigen) {
		super(codigo, nombre, precio, vencimiento, categoria, empresa, stock);
		this.fragancia = fragancia;
		this.cantidad = cantidad;
		this.paisOrigen = paisOrigen;
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return "Perfume fragancia=" + fragancia + ", cantidad=" + cantidad + " " + super.toString();
	}
}
