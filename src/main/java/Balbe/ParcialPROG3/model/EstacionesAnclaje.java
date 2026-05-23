package Balbe.ParcialPROG3.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionesAnclaje {

    private String nombreUnico;
    List<Vehiculo> vehiculosDisponibles = new ArrayList<>();

}
