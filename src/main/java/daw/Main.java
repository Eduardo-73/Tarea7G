/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.util.List;

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
    }
}
