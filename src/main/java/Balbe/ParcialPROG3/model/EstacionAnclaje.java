package Balbe.ParcialPROG3.model;
import java.util.List;

import Balbe.ParcialPROG3.exceptions.VehiculoNoEncontradoException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstacionAnclaje {

    private String nombre;
    private List<Vehiculo> vehiculos; // lista de vehículos disponibles en la estación

    public Vehiculo buscarPorPatente(String patente) { // necesitamos un metodo que busque a un vehiculo x su patente,
        // si no lo encuentra, lanza la exepcion
        for (Vehiculo v : vehiculos) {                        
            if (v.getPatente().equalsIgnoreCase(patente)) {   // ponemos esto para que se ignoren las mayusculas
                return v;                                      
            }
        }
        throw new VehiculoNoEncontradoException(patente); // si no encontro y salio del loop, lanza la excepcion
    }

}
