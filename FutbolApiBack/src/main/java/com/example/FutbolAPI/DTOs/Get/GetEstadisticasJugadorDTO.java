package com.example.FutbolAPI.DTOs.Get;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetEstadisticasJugadorDTO {
    Integer cantidadGoles;
    Integer partidosJugados;
    String piernaHabil;
}
