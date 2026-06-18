package Balbe.ParcialPROG3.model;

import java.util.Comparator;

public class ComparadorPorTarifa implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        return Double.compare(v2.getTarifaBase(), v1.getTarifaBase()); //agregamos el comparador externo
    }
}