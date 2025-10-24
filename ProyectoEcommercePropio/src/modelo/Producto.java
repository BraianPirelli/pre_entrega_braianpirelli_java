package modelo;

import java.util.Date;

public class Producto{
	private String codigo;
	private String nombre;
	private double precio;
	private Date vencimiento;
	private Categoria categoria;
	private Empresa empresa;
	private boolean estado;
	private int stock;
	
	public Producto(String codigo, String nombre, double precio, Date vencimiento, Categoria categoria, Empresa empresa, int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.vencimiento = vencimiento;
		this.categoria = categoria;
		this.empresa = empresa;
		this.estado = true;
		this.stock = stock;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		String mostrar = estado == true ? "DISPONIBLE" : "NO DISPONIBLE";
		return "codigo= " + codigo + ", nombre=" + nombre + ", precio=" + precio + ", vencimiento=" + vencimiento + ", categoria="
				+ categoria.getNombre() + ", empresa=" + empresa.getNombre() + ", stock= " + stock + ", estado= " + mostrar;
	}

	public String toString(String vacio) {
		return "codigo= " + codigo + ", nombre=" + nombre + ", precio=" + precio + ", vencimiento=" + vencimiento + ", categoria="
				+ categoria.getNombre() + ", empresa=" + empresa.getNombre();
	}
}
