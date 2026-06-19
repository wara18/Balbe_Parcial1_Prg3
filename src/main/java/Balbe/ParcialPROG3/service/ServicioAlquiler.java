package Balbe.ParcialPROG3.service;

import Balbe.ParcialPROG3.CargaDatos;
import Balbe.ParcialPROG3.dto.RespuestaDesbloqueoDTO;
import Balbe.ParcialPROG3.dto.RespuestaFinalizacionDTO;
import Balbe.ParcialPROG3.exceptions.BateriaInsuficienteException;
import Balbe.ParcialPROG3.exceptions.VehiculoNoEncontradoException;
import Balbe.ParcialPROG3.model.*;
import Balbe.ParcialPROG3.model.estrategia.EstrategiaTarifa;
import Balbe.ParcialPROG3.model.estrategia.TarifaEstandar;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ServicioAlquiler {

    private final CargaDatos cargaDatos;
    private final FabricaPagos fabrica;

    // estrategia activa, arranca estandar y se puede cambiar en runtime
    private EstrategiaTarifa estrategiaActual;

    public ServicioAlquiler(CargaDatos cargaDatos, FabricaPagos fabrica) {
        this.cargaDatos = cargaDatos;
        this.fabrica = fabrica;
        this.estrategiaActual = new TarifaEstandar();
    }

    // para cambiar la estrategia sin reiniciar la app
    public void setEstrategia(EstrategiaTarifa estrategia) {
        this.estrategiaActual = estrategia;
    }

    public RespuestaDesbloqueoDTO desbloquear(String idUsuario, String patente, String metodoPago) {

        // buscamos el vehiculo en todas las estaciones
        Vehiculo vehiculo = buscarVehiculoEnEstaciones(patente);

        // bateria minima 15%
        if (vehiculo.getPorcentajeBateria() < 15) {
            throw new BateriaInsuficienteException(vehiculo.getNumPatente());
            }

        Usuario usuario = cargaDatos.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario con id " + idUsuario + " no encontrado.");
        }

        // esto cambia el estado internamente via State Pattern
        vehiculo.iniciarViaje();

        // costo estimado con 1 minuto base solo para mostrar algo al desbloquear
        double costoEstimado = estrategiaActual.calcularCosto(vehiculo.getTarifaBase(), 1);
        costoEstimado = usuario.calcularImporte(costoEstimado);

        ProcesadorPago procesador = fabrica.crearProcesador(metodoPago);
        procesador.cobrar(costoEstimado);

        return new RespuestaDesbloqueoDTO(
                vehiculo.getNumPatente(),
                costoEstimado,
                vehiculo.getEstado().getNombre(),
                "Viaje iniciado correctamente."
        );
    }

    public RespuestaFinalizacionDTO finalizar(String idUsuario, String patente) {

        Vehiculo vehiculo = buscarVehiculoEnEstaciones(patente);

        Usuario usuario = cargaDatos.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario con id " + idUsuario + " no encontrado.");
        }

        // calculamos cuantos minutos paso desde que arranco el viaje
        LocalDateTime inicio = vehiculo.getTiempoInicioViaje();
        int minutos = (int) ChronoUnit.MINUTES.between(inicio, LocalDateTime.now());
        // minimo 1 minuto para no cobrar cero
        if (minutos < 1) minutos = 1;

        double costoFinal = estrategiaActual.calcularCosto(vehiculo.getTarifaBase(), minutos);
        costoFinal = usuario.calcularImporte(costoFinal);

        // cambia estado a EN_ESPERA
        vehiculo.finalizarViaje();

        return new RespuestaFinalizacionDTO(
                vehiculo.getNumPatente(),
                costoFinal,
                minutos,
                vehiculo.getEstado().getNombre()
        );
    }

    // busca en todas las estaciones, no solo una como antes
    private Vehiculo buscarVehiculoEnEstaciones(String patente) {
        List<EstacionAnclaje> estaciones = cargaDatos.getEstaciones();
        for (EstacionAnclaje estacion : estaciones) {
            try {
                return estacion.buscarPorPatente(patente);
            } catch (VehiculoNoEncontradoException e) {
                // no estaba en esta estacion, seguimos buscando
            }
        }
        throw new VehiculoNoEncontradoException("Vehículo con patente " + patente + " no encontrado en ninguna estación.");
    }
}