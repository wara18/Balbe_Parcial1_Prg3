package Balbe.ParcialPROG3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// respuesta cuando termina el viaje, aca si sabemos el costo real
@Getter
@AllArgsConstructor
public class RespuestaFinalizacionDTO {

    private String patente;
    private double costoFinal;
    // cuanto duro el viaje en minutos
    private int minutosTranscurridos;
    private String estadoVehiculo;
}