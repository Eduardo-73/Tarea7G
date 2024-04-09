/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author edu
 */
public record Estaciones(LocalDate fecha, String estacionMeteorologica, 
        String provincia, double precipitacion) {
    
}
