package Balbe.ParcialPROG3.model;

public class FabricaPagos { // forma que tenemos para realizar los pagos, recibe los canalesfinancieros

    public ProcesadorPago crearProcesador(CanalFinanciero canal) {
        switch (canal) {
            case TARJETA:
                return new ProcesadorTarjeta();
            case BILLETERA:
                return new ProcesadorBilletera();
            default:
                throw new IllegalArgumentException("Canal financiero no incorreto: " + canal);
        }
    }
}