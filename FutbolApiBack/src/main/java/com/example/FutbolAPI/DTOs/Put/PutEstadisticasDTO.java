package com.example.FutbolAPI.DTOs.Put;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PutEstadisticasDTO {
    Integer cantGoles;
    Integer partidosJugados;
    String piernaHabil;
}
