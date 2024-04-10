/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edu
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String ruta = "precipitacionesBadajoz.json";
        List<Estaciones> lista = Metodos.leerFichero(ruta);
        for (Estaciones estaciones : lista) {
            System.out.println(estaciones);
        }
        Map<String, Double> mapLista = Metodos.mapEstacion(lista);
        for (Map.Entry<String, Double> entry : mapLista.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + " -> " + val);
        }
        Metodos.escribirJSON(mapLista);
        double maxPreci = lista.stream()
                .mapToDouble(p -> p.precipitacion())
                .max()
                .getAsDouble();
        System.out.println(maxPreci);
        LocalDate inicio = LocalDate.of(2017, 10, 10);
        LocalDate fin = LocalDate.of(2017, 10, 20);
        long numEstaciones = lista.stream()
                .filter(p -> p.fecha().isAfter(inicio) && p.fecha().isBefore(fin))
                .count();
        System.out.println(numEstaciones);
        double mediaPrecipitaciones = lista.stream()
                .filter(p -> p.fecha().isAfter(inicio) && p.fecha().isBefore(fin))
                .mapToDouble(p -> p.precipitacion())
                .average()
                .getAsDouble();
        System.out.printf("%.2f",mediaPrecipitaciones);
    }
}
