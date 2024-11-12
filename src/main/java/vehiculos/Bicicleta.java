package vehiculos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bicicleta extends Vehiculo {
	private String tipoBicicleta;

	public Bicicleta() {
	}

	public Bicicleta(String marca, String modelo, int anio, int precio, String especialidad) {
		super(marca, modelo, anio, precio);
		this.tipoBicicleta = especialidad;
	}

	public String getTipo() {
		return "Bicicleta";
	}

	public String toString() {
		return "Tipo : " + this.getTipo() + " | " + super.toString() + " | " + "Especialidad: " + this.tipoBicicleta;
	}

	//Getter y Setter

	public String getTipoBicicleta() {
		return tipoBicicleta;
	}

	public void setTipoBicicleta(String tipoBicicleta) {
		this.tipoBicicleta = tipoBicicleta;
	}
}