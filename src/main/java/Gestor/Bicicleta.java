package Gestor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bicicleta extends Vehiculo {
	private String tipoBicicleta;

	public String getTipoBicicleta() {
		return this.tipoBicicleta;
	}

	public void setTipoBicicleta(String tipo) {
		this.tipoBicicleta = tipo;
	}

	public String getTipo() {
		return "Bicicleta";
	}

	public String toString() {
		return this.getTipo() + " " + super.toString() + " " + this.tipoBicicleta;
	}

	public Bicicleta(String marca, String modelo, int anio, int precio, String especialidad) {
		super(marca, modelo, anio, precio);
		this.tipoBicicleta = especialidad;
	}

	public Bicicleta() {
	}
}