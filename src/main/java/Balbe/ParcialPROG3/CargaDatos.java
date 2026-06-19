package Balbe.ParcialPROG3;

import Balbe.ParcialPROG3.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CargaDatos {

    // lista de usuarios en memoria, sin base de datos
    private List<Usuario> usuarios;
    // ahora tenemos dos estaciones
    private List<EstacionAnclaje> estaciones;

    public CargaDatos() {
        usuarios = new ArrayList<>();
        estaciones = new ArrayList<>();
        cargar();
    }

    private void cargar() {
        // usuarios de prueba
        usuarios.add(new UsuarioRegular("1", "Santiago Nunez"));
        usuarios.add(new UsuarioRegular("2", "Avila Wara"));
        usuarios.add(new UsuarioPremium("3", "Martin Francisco"));
        usuarios.add(new UsuarioPremium("4", "Perralta Lautaro"));

        // estacion centro
        EstacionAnclaje centro = new EstacionAnclaje("Estacion Centro");
        centro.agregarVehiculo(new Monopatin("ABC123", 80, 450.0, true));
        // este tiene bateria baja, deberia fallar al desbloquear
        centro.agregarVehiculo(new Monopatin("DEF456", 10, 450.0, false));

        // estacion norte
        EstacionAnclaje norte = new EstacionAnclaje("Estacion Norte");
        norte.agregarVehiculo(new Bicicleta("GHI789", 60, 500.0, 30));
        norte.agregarVehiculo(new Bicicleta("JKL012", 90, 500.0, 50));

        estaciones.add(centro);
        estaciones.add(norte);
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    // devuelve todos los vehiculos de todas las estaciones juntos
    public List<Vehiculo> getTodosLosVehiculos() {
        List<Vehiculo> todos = new ArrayList<>();
        for (EstacionAnclaje e : estaciones) {
            todos.addAll(e.getVehiculos());
        }
        return todos;
    }

    public List<EstacionAnclaje> getEstaciones() {
        return estaciones;
    }
}