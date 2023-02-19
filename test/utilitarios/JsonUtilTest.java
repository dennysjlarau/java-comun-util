package utilitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import excepciones.ArchivoIncorrectoException;

public class JsonUtilTest {

	String absolutePath = null;
	
	@Before
	public void validarRecursoTest() {
		String path = "test/resources";
		File file = new File(path);
		absolutePath = file.getAbsolutePath();
		assertTrue(absolutePath.endsWith("resources"));
		//System.out.println(absolutePath);
	}
	
	@Test
	public void leerArchivoJsonTest() {
		String archivo = "rest-get-user";
		JSONObject jso = JsonUtil.leerArchivo(absolutePath + "/" +  archivo);
		String valor = JsonUtil.obtenerValor(jso, "lastName");
		assertEquals("Sharma", valor);
	}
	
	@Test(expected = ArchivoIncorrectoException.class)
	public void leerArchivoJsonErrorTest() {
		String archivo = "rest-get-user.json";
		JsonUtil.leerArchivo(absolutePath + "/" +  archivo);
	}
}
