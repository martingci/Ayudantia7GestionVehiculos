package Gestor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Auto.class, name = "Auto"),
		@JsonSubTypes.Type(value = Bicicleta.class, name = "Bicicleta"),
		@JsonSubTypes.Type(value = Camion.class, name = "Camion")
})

public abstract class Vehiculo {
	protected String marca;
	protected String modelo;
	protected int anio;
	protected int precio;

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public abstract String getTipo();

	public String toString() {
		return this.marca + " " + this.modelo + " " + this.anio + " $" + this.precio;
	}

	public Vehiculo(String marca, String modelo, int anio, int precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
	}

	public Vehiculo() {}

}