package lectorJson;
import java.io.File;
import java.util.ArrayList;

import Gestor.Vehiculo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GestorDeDatos {

	public GestorDeDatos() {}

	private final ObjectMapper mapper = new ObjectMapper();

	public <T> ArrayList<T> leerJson(String ubicacionArchivo, Class<T> clase) {
		ArrayList<T> lista = new ArrayList<T>();
		try {
			lista = mapper.readValue(new File(ubicacionArchivo), mapper.getTypeFactory().constructCollectionType(ArrayList.class, clase));
		} catch (Exception e) {
			System.err.println("Error al leer el archivo en la ubicacion " + ubicacionArchivo + ": " + e.getMessage());
		}
		return lista;
	}

	public <T> void grabarJson(ArrayList<T> listaAGuardar, String ubicacionArchivo) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(ubicacionArchivo), listaAGuardar);
		} catch (Exception e) {
			System.err.println("Error al guardar el archivo en la ubicacion " + ubicacionArchivo + ": " + e.getMessage());
		}
	}

	public ArrayList<Vehiculo> LeerPersonajes(String ubicacionArchivo) {
		try {
			return mapper.readValue(new File(ubicacionArchivo),
					mapper.getTypeFactory().constructCollectionType(ArrayList.class, Vehiculo.class));

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}