package Balbe.ParcialPROG3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    private String numPatente;
    private int porcentajeBateria;
    private double tarifaBase;

}
