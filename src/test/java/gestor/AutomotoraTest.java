package gestor;

import lectorJson.GestorDeDatos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehiculos.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AutomotoraTest {

    GestorDeDatos gestor = new GestorDeDatos();
    Automotora automotora = new Automotora();

    @BeforeEach
    void setUp() {
        automotora.vehiculos = new ArrayList<Vehiculo>();
    }

    @AfterEach
    void tearDown() {
        automotora.vehiculos = new ArrayList<Vehiculo>();
    }

    @Test
    void agregarVehiculo() {
        Auto auto1 = new Auto("Toyota", "Corolla", 2019, 10000, 5);
        assertFalse(automotora.vehiculos.contains(auto1));
        Auto auto2 = new Auto("Toyota", "Yaris", 2019, 10000, 5);
        assertFalse(automotora.vehiculos.contains(auto2));
        Bicicleta bicicleta1 = new Bicicleta("Bici", "Bicicleta", 2020, 1000, "Montana");
        assertFalse(automotora.vehiculos.contains(bicicleta1));
        Bicicleta bicicleta2 = new Bicicleta("Bici", "Bicicleta", 2020, 1000, "Jardin");
        assertFalse(automotora.vehiculos.contains(bicicleta2));
        Camion camion1 = new Camion("Volvo", "FH", 2020, 100000, 2);
        assertFalse(automotora.vehiculos.contains(camion1));
        Camion camion2 = new Camion("Volvo", "FH", 2020, 100000, 2);
        assertFalse(automotora.vehiculos.contains(camion2));
        automotora.agregarVehiculo(auto1);
        assertTrue(automotora.vehiculos.contains(auto1));
        automotora.agregarVehiculo(auto2);
        assertTrue(automotora.vehiculos.contains(auto2));
        automotora.agregarVehiculo(bicicleta1);
        assertTrue(automotora.vehiculos.contains(bicicleta1));
        automotora.agregarVehiculo(bicicleta2);
        assertTrue(automotora.vehiculos.contains(bicicleta2));
        automotora.agregarVehiculo(camion1);
        assertTrue(automotora.vehiculos.contains(camion1));
        automotora.agregarVehiculo(camion2);
        assertTrue(automotora.vehiculos.contains(camion2));
    }

    @Test
    void cargarDatos() {
        // Se añaden manualmente todos los elementos del archivo vehiculos.json :c
        ArrayList<Vehiculo> vehiculos_test = new ArrayList<Vehiculo>();
        vehiculos_test.add(new Auto("Toyota", "Corolla", 2018, 15000, 4));
        vehiculos_test.add(new Auto("Ford", "Mustang", 2021, 35000, 2));
        vehiculos_test.add(new Camion("Mercedes-Benz", "Actros", 2019, 75000, 18));
        vehiculos_test.add(new Camion("Volvo", "FH16", 2020, 80000, 20));
        vehiculos_test.add(new Bicicleta("Giant", "Talon", 2022, 500, "Montania"));
        vehiculos_test.add(new Bicicleta("Specialized", "Sirrus", 2021, 600, "Ciudad"));
        automotora.cargarDatos();
        assertEquals(vehiculos_test.size(), automotora.vehiculos.size());
        // Intente comparar los dos ArrayList pero pese a no tener diferencias me daba false. Por eso se comparan los elementos uno a uno.
        //assertEquals(vehiculos_test, automotora.vehiculos);
        for (int i = 0; i < vehiculos_test.size(); i++) {
            assertEquals(vehiculos_test.get(i).getMarca(), automotora.vehiculos.get(i).getMarca());
            assertEquals(vehiculos_test.get(i).getModelo(), automotora.vehiculos.get(i).getModelo());
            assertEquals(vehiculos_test.get(i).getAnio(), automotora.vehiculos.get(i).getAnio());
            assertEquals(vehiculos_test.get(i).getPrecio(), automotora.vehiculos.get(i).getPrecio());
        }
    }

    @Test
    void guardarDatos() {
        Bicicleta bicicleta1 = new Bicicleta("Bici", "Bicicleta", 2020, 1000, "Montana");
        automotora.agregarVehiculo(bicicleta1);
        assertTrue(automotora.vehiculos.contains(bicicleta1));
        automotora.guardarDatos();
        ArrayList<Vehiculo> vehiculos_test = gestor.leerJson("datos/vehiculosNuevos.json", Vehiculo.class);
        for (int i = 0; i < vehiculos_test.size(); i++) {
            assertEquals(vehiculos_test.get(i).getMarca(), automotora.vehiculos.get(i).getMarca());
            assertEquals(vehiculos_test.get(i).getModelo(), automotora.vehiculos.get(i).getModelo());
            assertEquals(vehiculos_test.get(i).getAnio(), automotora.vehiculos.get(i).getAnio());
            assertEquals(vehiculos_test.get(i).getPrecio(), automotora.vehiculos.get(i).getPrecio());
        }
    }
}