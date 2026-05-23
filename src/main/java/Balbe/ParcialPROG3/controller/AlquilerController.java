package Balbe.ParcialPROG3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Balbe.ParcialPROG3.service.ServicioAlquiler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AlquilerController {

    @Autowired
    private ServicioAlquiler servicio;

    @GetMapping("/desbloquear/{idUsuario}/{patente}/{metodoPago}") // cambio esto pq si no, no sabemos como pasarle el JSON
public ResponseEntity<String> desbloquear(
    @PathVariable String idUsuario,
    @PathVariable String patente,
    @PathVariable String metodoPago) {
    
    String resultado = servicio.desbloquear(idUsuario, patente, metodoPago);
    return ResponseEntity.ok(resultado);
}


}
