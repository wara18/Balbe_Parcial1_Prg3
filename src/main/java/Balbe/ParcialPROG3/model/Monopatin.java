package Balbe.ParcialPROG3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monopatin extends Vehiculo {

    private boolean cuentaConAmortiguacion;

    public Monopatin(String numPatente, int porcentajeBateria, double tarifaBase, boolean cuentaConAmortiguacion) {
        super(numPatente, porcentajeBateria, tarifaBase);
        this.cuentaConAmortiguacion = cuentaConAmortiguacion;
    }

}
