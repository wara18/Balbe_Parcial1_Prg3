package Balbe.ParcialPROG3.model;

import lombok.Getter;

@Getter // añado el getter
public class Bicicleta extends Vehiculo {

    private int capacidadCanasto;

    public Bicicleta(String numPatente, int porcentajeBateria, double tarifaBase, int capacidadCanasto) {
        super(numPatente, porcentajeBateria, tarifaBase);
        this.capacidadCanasto = capacidadCanasto;
    }
}