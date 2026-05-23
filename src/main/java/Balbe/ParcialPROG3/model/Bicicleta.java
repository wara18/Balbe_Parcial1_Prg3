package Balbe.ParcialPROG3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bicicleta extends Vehiculo{

    private int capacidadCanasto;

    public Bicicleta(String numPatente, int porcentajeBateria, double tarifaBase, int capacidadCanasto) {
        super(numPatente, porcentajeBateria, tarifaBase);
        this.capacidadCanasto = capacidadCanasto;
    }

}
