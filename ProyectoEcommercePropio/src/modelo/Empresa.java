package modelo;

public class Empresa {
	private String nombre;
	private String descripcion;
	private boolean estado;
	
	public Empresa(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = true;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		String state = estado ? "activa" : "inactiva";
		return "Empresa [nombre=" + nombre + ", descripcion=" + descripcion + "(" + state + ")" + "]";
	}
	
}
