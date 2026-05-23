package Balbe.ParcialPROG3.model;

public class ProcesadorTarjeta implements ProcesadorPago { // procesador de tarjeta que simula un cobro

    @Override
    public void cobrar(double monto) {
        System.out.println("Cobro exitoso de $" + monto + " realizado con Tarjeta de Crédito");
    }
}