package Gestor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto extends Vehiculo {
	private String tipo;
	private int numeroPuertas;

	public int getNumeroPuertas() {
		return this.numeroPuertas;
	}

	public void setNumeroPuertas(int puertas) {
		this.numeroPuertas = puertas;
	}

	public String getTipo() {
		return "Auto";
	}

	public String toString() {
		return this.getTipo() + " " + super.toString() + " " + this.numeroPuertas + " puertas";
	}

	public Auto(String marca, String modelo, int ano, int puertas, int precio) {
		super(marca, modelo, ano, precio);
		this.tipo = "Auto";
		this.numeroPuertas = puertas;
	}

	public Auto() {
	}
}