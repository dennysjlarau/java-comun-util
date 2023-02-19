/**
 * 
 */
package utilitarios;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import excepciones.ArchivoIncorrectoException;

/**
 * @author dennys
 * Utilitario para la gestion de archivos json
 *
 */
public final class JsonUtil {

	private final static String JSON_EXTENSION = ".json";

	public static JSONObject leerArchivo (String archivo) throws ArchivoIncorrectoException {
		Object ob = null;
		try {
			ob = new JSONParser().parse(new FileReader(archivo + JSON_EXTENSION));
		} catch (IOException | ParseException e) {
			LoggerUtil.getLogger(JsonUtil.class.getName()).error("Error al leer archivo: " + archivo, e);
			throw new ArchivoIncorrectoException("Error en el Archivo");
		}
        return (JSONObject) ob;
	}
	
	public static String obtenerValor (JSONObject jsonObjeto, String etiqueta) {
		return (String) jsonObjeto.get(etiqueta);
	}
	
	public static String obtenerArreglo (JSONObject jsonObjeto, String etiqueta) {
		StringBuilder sb = new StringBuilder();
		JSONArray jsonArray = (JSONArray) jsonObjeto.get(etiqueta);
		if (jsonArray == null || jsonArray.isEmpty()) {
			LoggerUtil.getLogger(JsonUtil.class.getName()).error("No existe etiqueta: " + etiqueta);
			throw new ArchivoIncorrectoException("Error en la etiqueta");
		} else {
			for (int i = 0; i < jsonArray.size(); i++) {
				sb.append(jsonArray.get(i));
			}
			return sb.toString();
		}
	}
	
	
}
