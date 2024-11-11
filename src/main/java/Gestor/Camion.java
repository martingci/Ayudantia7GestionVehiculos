package Gestor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Camion extends Vehiculo {
	private int capacidadCargaToneladas;

	public Camion(String marca, String modelo, int ano, int precio, int capacidad) {
		super(marca, modelo, ano, precio);
		this.capacidadCargaToneladas = capacidad;
	}

	public Camion() {}

	public int getCapacidadCargaToneladas() {
		return this.capacidadCargaToneladas;
	}

	public String getTipo() {
		return "Camion";
	}

	public String toString() {
		return this.getTipo() + " " + super.toString() + " " + this.capacidadCargaToneladas + " kg";
	}

	public void setCapacidadCargaToneladas(int capacidadCargaToneladas) {
		this.capacidadCargaToneladas = capacidadCargaToneladas;
	}

}