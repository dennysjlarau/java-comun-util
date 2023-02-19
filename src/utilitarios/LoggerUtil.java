package utilitarios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtil {

	public static Logger getLogger(String nombreClase) {
		return LogManager.getLogger(nombreClase);
	}
}
