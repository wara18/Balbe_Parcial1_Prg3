package Balbe.ParcialPROG3.exceptions;

public class EstadoInvalidoException extends RuntimeException {
    public EstadoInvalidoException(String mensaje) { // agregamos excepcion para estadoinvalido
        super(mensaje);
    }
}