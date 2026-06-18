package Balbe.ParcialPROG3.model.estado;

import Balbe.ParcialPROG3.exceptions.EstadoInvalidoException;

public class EstadoEnViaje implements EstadoVehiculo {

    private final VehiculoContext contexto;

    public EstadoEnViaje(VehiculoContext contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        throw new EstadoInvalidoException("El vehículo ya está en viaje.");
    }

    @Override
    public void finalizarViaje() {
        contexto.setEstado(new EstadoEnEspera(contexto));
    }

    @Override
    public void enviarAMantenimiento() {
        throw new EstadoInvalidoException("No se puede enviar a mantenimiento: el vehículo está en viaje.");
    }

    @Override
    public String getNombre() {
        return "EN_VIAJE";
    }
}