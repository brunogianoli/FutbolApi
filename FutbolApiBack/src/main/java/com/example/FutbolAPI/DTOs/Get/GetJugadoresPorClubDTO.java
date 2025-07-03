package com.example.FutbolAPI.DTOs.Get;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetJugadoresPorClubDTO {
    private String nombre;
    private String posicion;
}
