package excepciones;

public class ArchivoIncorrectoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArchivoIncorrectoException (String mensajeError) {
		super(mensajeError);
	}

}
