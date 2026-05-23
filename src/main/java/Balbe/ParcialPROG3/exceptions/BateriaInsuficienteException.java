package Balbe.ParcialPROG3.exceptions;

public class BateriaInsuficienteException extends RuntimeException {
    public BateriaInsuficienteException(String patente) {
        super("Batería Insuficiente: el vehículo con patente '" + patente + "' tiene menos del 15% de batería.");
    }
}
