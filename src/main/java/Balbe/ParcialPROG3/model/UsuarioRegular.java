package Balbe.ParcialPROG3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UsuarioRegular extends Usuario{

    public UsuarioRegular(String nombreCompleto, String id) {
        super(nombreCompleto, id);
    }

    // por mas que no tenga descuento tiene que tener el metodo debido a que la clase usuario es abstracta
    @Override
    public double calcularImporte(double tarifaBase) {
        return tarifaBase;
    }

}
