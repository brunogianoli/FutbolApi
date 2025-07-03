package com.example.FutbolAPI.DTOs.Get;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetJugadoresDTO {
    private Long id;
    private String nombre;
    private String posicion;
    private String debut;
}
