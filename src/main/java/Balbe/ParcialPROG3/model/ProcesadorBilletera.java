package Balbe.ParcialPROG3.model;

public class ProcesadorBilletera implements ProcesadorPago { // clase que implementa la interfaz procesador de pago, cumpliendo su contrato

    @Override
    public void cobrar(double monto) {
        System.out.println("Cobro exitoso de " + monto + " realizado con Billetera Virtual");
    }
}