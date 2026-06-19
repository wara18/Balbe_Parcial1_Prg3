package Balbe.ParcialPROG3.controller;

import Balbe.ParcialPROG3.CargaDatos;
import Balbe.ParcialPROG3.model.ComparadorPorTarifa;
import Balbe.ParcialPROG3.model.Vehiculo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// endpoints para ver la flota ordenada
@AllArgsConstructor
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private CargaDatos cargaDatos;

    // ordenado por bateria de menor a mayor, usa el compareTo natural de Vehiculo
    @GetMapping("/prioridad-carga")
    public ResponseEntity<List<Vehiculo>> prioridadCarga() {
        List<Vehiculo> lista = new ArrayList<>(cargaDatos.getTodosLosVehiculos());
        Collections.sort(lista);
        return ResponseEntity.ok(lista);
    }

    // ordenado por tarifa de mayor a menor, usa el comparador externo
    @GetMapping("/tarifa-descendente")
    public ResponseEntity<List<Vehiculo>> tarifaDescendente() {
        List<Vehiculo> lista = new ArrayList<>(cargaDatos.getTodosLosVehiculos());
        Collections.sort(lista, new ComparadorPorTarifa());
        return ResponseEntity.ok(lista);
    }
}