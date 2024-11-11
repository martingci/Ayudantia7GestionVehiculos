package Gestor;

import lectorJson.GestorDeDatos;

import java.util.ArrayList;

public class Automotora {
	ArrayList<Auto> autos;
	ArrayList<Bicicleta> bicicletas;
	ArrayList<Camion> camiones;
	ArrayList<Vehiculo> vehiculos;

	public void agregarAuto(Auto auto) {
		autos.add(auto);
	}

	public void agregarBicicleta(Bicicleta bicicleta) {
		bicicletas.add(bicicleta);
	}

	public void agregarCamion(Camion camion) {
		camiones.add(camion);
	}

	public void listar() {
		vehiculos.addAll(autos);
		vehiculos.addAll(bicicletas);
		vehiculos.addAll(camiones);
		vehiculos.forEach(System.out::println);
	}

	public Automotora() {
		autos = new ArrayList<Auto>();
		bicicletas = new ArrayList<Bicicleta>();
		camiones = new ArrayList<Camion>();
		vehiculos = new ArrayList<Vehiculo>();
	}

	public static void main(String[] args) {
		GestorDeDatos gestor = new GestorDeDatos();
		Automotora automotora = new Automotora();
		automotora.vehiculos = gestor.LeerPersonajes("datos/vehiculos.json");
		for (Vehiculo vehiculo : automotora.vehiculos) {
			System.out.println(vehiculo);
			switch (vehiculo.getTipo()) {
				case "Auto":
					automotora.agregarAuto((Auto) vehiculo);
					break;
				case "Bicicleta":
					automotora.agregarBicicleta((Bicicleta) vehiculo);
					break;
				case "Camion":
					automotora.agregarCamion((Camion) vehiculo);
					break;
			}
		}
		System.out.println("---------------------------");
		for (Auto auto : automotora.autos) {
			System.out.println(auto);
		}
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		for (Bicicleta bicicleta : automotora.bicicletas) {
			System.out.println(bicicleta);
		}
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		for (Camion camion : automotora.camiones) {
			System.out.println(camion);
		}
		System.out.println("---------------------------");
	}

}