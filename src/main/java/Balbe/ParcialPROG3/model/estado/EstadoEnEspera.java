package Balbe.ParcialPROG3.model.estado;

import Balbe.ParcialPROG3.exceptions.EstadoInvalidoException;

public class EstadoEnEspera implements EstadoVehiculo {

    private final VehiculoContext contexto;

    public EstadoEnEspera(VehiculoContext contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        contexto.setEstado(new EstadoEnViaje(contexto));
    }

    @Override
    public void finalizarViaje() {
        throw new EstadoInvalidoException("No se puede finalizar un viaje: el vehículo no está en viaje.");
    }

    @Override
    public void enviarAMantenimiento() {
        contexto.setEstado(new EstadoEnReparacion(contexto));
    }

    @Override
    public String getNombre() {
        return "EN_ESPERA";
    }
}