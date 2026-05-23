package Balbe.ParcialPROG3.service;

import org.springframework.stereotype.Service;

import Balbe.ParcialPROG3.exceptions.BateriaInsuficienteException;
import Balbe.ParcialPROG3.model.EstacionAnclaje;
import Balbe.ParcialPROG3.model.FabricaPagos;
import Balbe.ParcialPROG3.model.ProcesadorPago;
import Balbe.ParcialPROG3.model.Usuario;
import Balbe.ParcialPROG3.model.Vehiculo;

@Service
public class ServicioAlquiler {

    private EstacionAnclaje estacion;   // estación donde se busca el vehículo
    private FabricaPagos fabrica;        // fábrica que devuelve el procesador de pago correcto

    // metodo apara ver si se desbloquea el vehiculo
    public String desbloquear(String idUsuario, String patente, String metodoPago) {

        // primero busca por vehiculo y tira excepcion si no encuentra
        Vehiculo vehiculo = estacion.buscarPorPatente(patente);

        // despues verifica que la bateria sea suf
        if (vehiculo.getPorcentajeBateria() < 15) {
            throw new BateriaInsuficienteException(patente);
        }

        // si pasa las validaciones llega aqui

        ///////////
        ProcesadorPago procesador = fabrica.crearProcesador(metodoPago);
        procesador.cobrar(vehiculo.getTarifaBase());

        return "Desbloqueo exitoso del vehículo " + patente + ". Cobro realizado con " + metodoPago + ".";
    }
}