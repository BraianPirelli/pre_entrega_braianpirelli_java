package modelo;

public class Categoria {
	private String nombre;
	private String descripcion;
	private boolean estado;

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
	
	public Categoria(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = true;
	}
	
	@Override
	public String toString() {
		String state = estado ? "activa" : "inactiva";
		return "Categoria [nombre=" + nombre + ", descripcion=" + descripcion + "(" + state + ")" + "]";
	}
}
