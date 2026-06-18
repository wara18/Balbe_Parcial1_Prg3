package Balbe.ParcialPROG3.model;

import Balbe.ParcialPROG3.model.estado.EstadoEnEspera;
import Balbe.ParcialPROG3.model.estado.EstadoVehiculo;
import Balbe.ParcialPROG3.model.estado.VehiculoContext;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
public class Vehiculo implements Comparable<Vehiculo>, VehiculoContext {

    private String numPatente;
    private int porcentajeBateria;
    private double tarifaBase;

    @Setter
    private EstadoVehiculo estado;

    private LocalDateTime tiempoInicioViaje;

    public Vehiculo(String numPatente, int porcentajeBateria, double tarifaBase) {
        this.numPatente = numPatente;
        this.porcentajeBateria = porcentajeBateria;
        this.tarifaBase = tarifaBase;
        this.estado = new EstadoEnEspera(this);
    }

    public void iniciarViaje() {
        estado.iniciarViaje();
        this.tiempoInicioViaje = LocalDateTime.now(); // usando la libreria
    }

    public void finalizarViaje() {
        estado.finalizarViaje();
        this.tiempoInicioViaje = null;
    }

    public void enviarAMantenimiento() {
        estado.enviarAMantenimiento();
    }

    @Override
    public int compareTo(Vehiculo otro) {
        return Integer.compare(this.porcentajeBateria, otro.porcentajeBateria); // bateria de mayor de menor comparamos
    }
}