package gestor;

import vehiculos.*;
import lectorJson.GestorDeDatos;
import java.util.ArrayList;

public class Automotora {
	ArrayList<Vehiculo> vehiculos;

	public Automotora() {
		vehiculos = new ArrayList<Vehiculo>();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		if (!this.vehiculos.contains(vehiculo)) {
			this.vehiculos.add(vehiculo);
		}
	}

	public void listar() {
		this.vehiculos.forEach(System.out::println);
	}

	public void cargarDatos() {
		GestorDeDatos gestor = new GestorDeDatos();
		this.vehiculos = gestor.leerJson("datos/vehiculos.json", Vehiculo.class);
	}

	public void guardarDatos() {
		GestorDeDatos gestor = new GestorDeDatos();
		gestor.grabarJson(this.vehiculos, "datos/vehiculosNuevos.json");
	}

}