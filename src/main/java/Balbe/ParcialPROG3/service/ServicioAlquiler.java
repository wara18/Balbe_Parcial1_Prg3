package Balbe.ParcialPROG3.service;

import org.springframework.stereotype.Service;

import Balbe.ParcialPROG3.CargaDatos;
import Balbe.ParcialPROG3.exceptions.BateriaInsuficienteException;
import Balbe.ParcialPROG3.model.EstacionAnclaje;
import Balbe.ParcialPROG3.model.FabricaPagos;
import Balbe.ParcialPROG3.model.ProcesadorPago;
import Balbe.ParcialPROG3.model.Usuario;
import Balbe.ParcialPROG3.model.Vehiculo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ServicioAlquiler {

    private EstacionAnclaje estacion;
    private FabricaPagos fabrica;
    private CargaDatos cargaDatos;

    private Usuario buscarUsuarioPorId(String id) { // esto lo agregams para ver que tipo de usuario es
        for (Usuario u : cargaDatos.getUsuarios()) { // mediante un foreach
            if (u.getId().equals(id)) {
                return u;
            }
        }
        throw new RuntimeException("Usuario no encontrado: " + id); // excepcion si no se encuentra usuario
    }

    // metodo apara ver si se desbloquea el vehiculo
    public String desbloquear(String idUsuario, String patente, String metodoPago) {

        // primero busca por vehiculo y tira excepcion si no encuentra
        Vehiculo vehiculo = estacion.buscarPorPatente(patente);

        // despues verifica que la bateria sea suf
        if (vehiculo.getPorcentajeBateria() < 15) {
            throw new BateriaInsuficienteException(patente);
        }

        Usuario usuario = buscarUsuarioPorId(idUsuario); // sabemos si es premium o regular

        // si pasa las validaciones llega aqui
        double importe = usuario.calcularImporte(vehiculo.getTarifaBase()); // calcula el importe teniendo en cuenta el tipo de user
        ProcesadorPago procesador = fabrica.crearProcesador(metodoPago);
        procesador.cobrar(importe); // se cobra el pago

        return "Desbloqueo exitoso del vehículo " + patente + ". Cobro realizado con " + metodoPago + ".";
    }
}