package com.example.FutbolAPI.DTOs.Put;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutEstadisticasDTO {
    Integer cantidadGoles;
    Integer partidosJugados;
    String piernaHabil;
}
