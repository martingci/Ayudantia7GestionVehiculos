package vehiculos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Camion extends Vehiculo {
	private int capacidadCargaToneladas;

	public Camion() {}

	public Camion(String marca, String modelo, int ano, int precio, int capacidad) {
		super(marca, modelo, ano, precio);
		this.capacidadCargaToneladas = capacidad;
	}

	public String toString() {
		return "Tipo : " + this.getTipo() + " | " + super.toString() + " | " + "Capacidad: " + this.capacidadCargaToneladas + " ton";
	}

	public String getTipo() {
		return "Camion";
	}

	//Getter y Setter

	public int getCapacidadCargaToneladas() {
		return capacidadCargaToneladas;
	}

	public void setCapacidadCargaToneladas(int capacidadCargaToneladas) {
		this.capacidadCargaToneladas = capacidadCargaToneladas;
	}
}