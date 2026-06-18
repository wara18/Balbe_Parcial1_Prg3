package Balbe.ParcialPROG3.model.estado;

public interface EstadoVehiculo {
    void iniciarViaje();
    void finalizarViaje();
    void enviarAMantenimiento();
    String getNombre();
}