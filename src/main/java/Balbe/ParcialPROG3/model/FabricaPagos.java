package Balbe.ParcialPROG3.model;

public class FabricaPagos { // forma que tenemos para realizar los pagos, recibe los canalesfinancieros

    public ProcesadorPago crearProcesador(String metodoPago) {
    if (metodoPago.equalsIgnoreCase("TARJETA")) { // compara a ver si el metodo ingresado es tarjeta
        return new ProcesadorTarjeta();
    } else {
        return new ProcesadorBilletera();  // si no es tarjeta asume que es una billetera
        }
    }
}


