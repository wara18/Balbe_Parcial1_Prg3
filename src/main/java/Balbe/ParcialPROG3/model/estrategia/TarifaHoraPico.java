package Balbe.ParcialPROG3.model.estrategia;

public class TarifaHoraPico implements EstrategiaTarifa {
    private static final double RECARGO = 0.40;

    @Override
    public double calcularCosto(double tarifaBase, int minutos) {
        double base = tarifaBase * minutos;
        return base + (base * RECARGO);
    }
}