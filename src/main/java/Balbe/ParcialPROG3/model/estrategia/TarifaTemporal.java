package Balbe.ParcialPROG3.model.estrategia;

public class TarifaTemporal implements EstrategiaTarifa {
    private static final double RECARGO_PLANO = 150.0;

    @Override
    public double calcularCosto(double tarifaBase, int minutos) {
        return (tarifaBase * minutos) + RECARGO_PLANO;
    }
}