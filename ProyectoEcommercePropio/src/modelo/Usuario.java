package modelo;

public class Usuario {
	private static int id = 0;
	private int idPropio;
	private String usuario;
	private String contrasenia;
	private boolean estado;
	
	public Usuario(String usuario, String contrasenia) {
		this.idPropio = getID();
		id = id++;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.estado = true;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public static int getID() {
		return id;
	}
	
	public int getIdPropio() {
		return idPropio;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		String state = estado ? "activo" : "inactivo";
		return "id= " + idPropio + " - usuario=" + usuario + " - contrasenia= " + contrasenia + " - (" + state + ")";
	}
}
