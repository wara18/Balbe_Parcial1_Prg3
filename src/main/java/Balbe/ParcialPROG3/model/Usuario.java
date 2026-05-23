package Balbe.ParcialPROG3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario { // modificamos la clase para hacerla abstracta

    private String nombreCompleto;
    private String id;

    public abstract double calcularImporte(double tarifaBase); // agregamos un metodo abstracto
    
}
