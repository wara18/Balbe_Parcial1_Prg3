package Balbe.ParcialPROG3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// esto es lo que le mandamos al cliente, sin exponer la entidad entera
@Getter
@AllArgsConstructor
public class RespuestaDesbloqueoDTO {

    // solo lo que necesita ver el usuario
    private String patente;
    private double costoEstimado;
    private String estadoVehiculo;
    private String mensaje;
}