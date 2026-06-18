package Balbe.ParcialPROG3.model.estrategia;

public class TarifaEstandar implements EstrategiaTarifa {
    @Override
    public double calcularCosto(double tarifaBase, int minutos) {
        return tarifaBase * minutos;
    }
}