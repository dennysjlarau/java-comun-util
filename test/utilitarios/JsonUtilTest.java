package utilitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import excepciones.ArchivoIncorrectoException;
import pojos.ObjetoComun;

public class JsonUtilTest {

	String absolutePath = null;
	private final static String ARCHIVO_RESOURCES = "rest-get-user";
	
	@Before
	public void validarRecursoTest() {
		String path = "test/resources";
		File file = new File(path);
		absolutePath = file.getAbsolutePath();
		assertTrue(absolutePath.endsWith("resources"));
		LoggerUtil.getLogger(JsonUtil.class.getName()).info("Error al leer archivo: " + absolutePath);
	}
	
	@Test
	public void leerArchivoJsonTest() {
		JSONObject jso = JsonUtil.leerArchivo(absolutePath + "/" +  ARCHIVO_RESOURCES);
		String valor = JsonUtil.obtenerValor(jso, "lastName");
		assertEquals("Sharma", valor);
	}
	
	@Test(expected = ArchivoIncorrectoException.class)
	public void leerArchivoJsonErrorTest() {
		JsonUtil.leerArchivo(absolutePath + "/rest-get-user.json");
	}

	@Test
	public void obtenerListaObjetoComunTest() throws ParseException {
		JSONObject jso = JsonUtil.leerArchivo(absolutePath + "/" + ARCHIVO_RESOURCES);
		List<ObjetoComun> cabeceraLista = JsonUtil.obtenerListaObjetoComun(jso, "headers");
		assertEquals("etiqueta-prueba", cabeceraLista.get(1).getNombre());
		assertEquals("valor prueba", cabeceraLista.get(1).getValor());

	}

}
