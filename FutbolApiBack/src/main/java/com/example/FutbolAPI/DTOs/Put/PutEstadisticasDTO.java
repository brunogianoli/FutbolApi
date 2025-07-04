package com.example.FutbolAPI.DTOs.Put;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PutEstadisticasDTO {
    Integer cantidadGoles;
    Integer partidosJugados;
    String piernaHabil;
}
