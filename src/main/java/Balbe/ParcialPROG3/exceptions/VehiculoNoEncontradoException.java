package Balbe.ParcialPROG3.exceptions;

public class VehiculoNoEncontradoException extends RuntimeException {
    public VehiculoNoEncontradoException(String patente) {
        super("Vehículo No Encontrado: no existe un rodado con patente '" + patente + "' en esta estación.");
    }
}
