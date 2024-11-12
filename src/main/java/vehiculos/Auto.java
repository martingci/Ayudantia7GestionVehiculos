package vehiculos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto extends Vehiculo {
	private String tipo;
	private int numeroPuertas;

	public Auto() {
	}

	// Constructor no es necesario para poder crear los objetos desde el Json

	public Auto(String marca, String modelo, int anio, int precio, int numeroPuertas) {
		super(marca, modelo, anio, precio);
		this.tipo = "Vehiculo";
		this.numeroPuertas = numeroPuertas;
	}

	public String getTipo() {
		return "Auto";
	}

	public String toString() {
		return "Tipo : " + this.getTipo() + " | " +super.toString() + " | " + "Número de puertas: " +this.numeroPuertas + " puertas";
	}

	//Getter y Setter

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
}