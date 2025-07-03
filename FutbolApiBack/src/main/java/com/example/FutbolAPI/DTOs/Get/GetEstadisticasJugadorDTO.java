package com.example.FutbolAPI.DTOs.Get;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetEstadisticasJugadorDTO {
    Integer cantGoles;
    Integer partidosJugados;
    String piernaHabil;
}
