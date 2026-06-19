package Balbe.ParcialPROG3.controller;

import Balbe.ParcialPROG3.dto.RespuestaDesbloqueoDTO;
import Balbe.ParcialPROG3.dto.RespuestaFinalizacionDTO;
import Balbe.ParcialPROG3.service.ServicioAlquiler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// controlador principal de alquileres
@AllArgsConstructor
@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private ServicioAlquiler servicio;

    @GetMapping("/desbloquear/{idUsuario}/{patente}/{metodoPago}")
    public ResponseEntity<RespuestaDesbloqueoDTO> desbloquear(
            @PathVariable String idUsuario,
            @PathVariable String patente,
            @PathVariable String metodoPago) {

        // ahora devuelve DTO en vez de String
        RespuestaDesbloqueoDTO respuesta = servicio.desbloquear(idUsuario, patente, metodoPago);
        return ResponseEntity.ok(respuesta);
    }

    // endpoint nuevo para finalizar el viaje
    @GetMapping("/finalizar/{idUsuario}/{patente}")
    public ResponseEntity<RespuestaFinalizacionDTO> finalizar(
            @PathVariable String idUsuario,
            @PathVariable String patente) {

        RespuestaFinalizacionDTO respuesta = servicio.finalizar(idUsuario, patente);
        return ResponseEntity.ok(respuesta);
    }
}