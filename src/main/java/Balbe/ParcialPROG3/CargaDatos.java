package Balbe.ParcialPROG3;

import org.springframework.stereotype.Component;

import Balbe.ParcialPROG3.model.*;


import java.util.ArrayList;
import java.util.List;

@Component
public class CargaDatos {

    // listas en memoria, sin base de datos como pide la consigna
    private List<Usuario> usuarios = new ArrayList<>();
    private List<EstacionAnclaje> estaciones = new ArrayList<>();

    public CargaDatos() {

        // ------- USUARIOS -------
        usuarios.add(new UsuarioRegular("Santiago Nunez", "1"));
        usuarios.add(new UsuarioRegular("Avila Wara", "2"));
        usuarios.add(new UsuarioPremium("Martin Fransicco", "3"));  // tiene 10% descuento
        usuarios.add(new UsuarioPremium("Perralta lautaro", "4"));

        // ------- VEHICULOS -------
        Monopatin m1 = new Monopatin("ABC123", 80, 450.0, true);
        Monopatin m2 = new Monopatin("DEF456", 10, 450.0, false); // batería baja, va a fallar
        Bicicleta b1 = new Bicicleta("GHI789", 60, 500.0, 30);
        Bicicleta b2 = new Bicicleta("JKL012", 90, 500.0, 50);

        // ------- ESTACIONES -------
        List<Vehiculo> vehiculosEstacion1 = new ArrayList<>();
        vehiculosEstacion1.add(m1);
        vehiculosEstacion1.add(b1);

        List<Vehiculo> vehiculosEstacion2 = new ArrayList<>();
        vehiculosEstacion2.add(m2);
        vehiculosEstacion2.add(b2);

        estaciones.add(new EstacionAnclaje("Estacion Centro", vehiculosEstacion1));
        estaciones.add(new EstacionAnclaje("Estacion Norte", vehiculosEstacion2));
    }

    public List<Usuario> getUsuarios() { return usuarios; }
    public List<EstacionAnclaje> getEstaciones() { return estaciones; }
}