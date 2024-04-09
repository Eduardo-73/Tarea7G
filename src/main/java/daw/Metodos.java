/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author edu
 */
public class Metodos {

    public static List<Estaciones> leerFichero(String ruta) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        List<Estaciones> catalogo = mapeador.readValue(new File(ruta),
                mapeador.getTypeFactory()
                        .constructCollectionLikeType(ArrayList.class,
                                Estaciones.class));
        return catalogo;
    }

    public static Map<String, Double> mapEstacion(List<Estaciones> lista) {
        Map<String, Double> mapLista = new TreeMap();
        for (Estaciones e : lista) {
            mapLista.put(e.estacionMeteorologica(), e.precipitacion());
        }
        return mapLista;
    }
}
