package Balbe.ParcialPROG3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UsuarioPremium extends Usuario{

    private static final double DESCUENTO = 0.10; // 10 de descuento

    public UsuarioPremium(String nombreCompleto, String id) {
        super(nombreCompleto, id);
    }

    @Override
    public double calcularImporte(double tarifaBase) {
        return tarifaBase - (tarifaBase * DESCUENTO); // applicacion del descuento teniendo en cuenta la tarifa
    }

}
