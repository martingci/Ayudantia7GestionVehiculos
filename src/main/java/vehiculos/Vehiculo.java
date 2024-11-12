package vehiculos;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Determinar por medio del parametro tipo que constructor utilizar.

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

	// Constructor no es necesario para poder crear los objetos desde el Json

	public Vehiculo(String marca, String modelo, int anio, int precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
	}

	public Vehiculo() {}

	public abstract String getTipo();

	// Getter y Setter

	public String toString() {
		return "Marca : " + this.marca + " | " + "Modelo: " + this.modelo + " | " + "Año: " + this.anio + " |  Precio: $" + this.precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}