package execpciones;

public class IngresoInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IngresoInvalidoException(String mensaje) {
		super(mensaje);
	}
}
