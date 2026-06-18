package Balbe.ParcialPROG3.model;

import Balbe.ParcialPROG3.exceptions.VehiculoNoEncontradoException;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
public class EstacionAnclaje {

    private String nombre;
    // cambiamos la lista por hashmap para buscar por patente directo sin recorrer todo
    private Map<String, Vehiculo> vehiculos;

    public EstacionAnclaje(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new HashMap<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        // la patente es la clave, facil de buscar despues
        vehiculos.put(vehiculo.getNumPatente(), vehiculo);
    }

    public Vehiculo buscarPorPatente(String patente) {
        Vehiculo vehiculo = vehiculos.get(patente);
        // si no existe lanzamos la excepcion custom
        if (vehiculo == null) {
            throw new VehiculoNoEncontradoException("Vehículo con patente " + patente + " no encontrado.");
        }
        return vehiculo;
    }

    // devuelve solo los valores del mapa, no las claves
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos.values();
    }
}