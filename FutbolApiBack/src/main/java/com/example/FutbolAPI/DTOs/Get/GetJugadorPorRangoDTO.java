package com.example.FutbolAPI.DTOs.Get;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetJugadorPorRangoDTO {
    private String nombre;
    private String posicion;
    private String debut;
    private String retiro;
}
