package Balbe.ParcialPROG3.model.estado;

import Balbe.ParcialPROG3.exceptions.EstadoInvalidoException;

public class EstadoEnReparacion implements EstadoVehiculo {

    private final VehiculoContext contexto;

    public EstadoEnReparacion(VehiculoContext contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        throw new EstadoInvalidoException("El vehículo está en reparación y no puede iniciar un viaje.");
    }

    @Override
    public void finalizarViaje() {
        throw new EstadoInvalidoException("No hay viaje activo para finalizar.");
    }

    @Override
    public void enviarAMantenimiento() {
        throw new EstadoInvalidoException("El vehículo ya está en reparación.");
    }

    @Override
    public String getNombre() {
        return "EN_REPARACION";
    }
}