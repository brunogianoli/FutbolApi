package com.example.FutbolAPI.DTOs.Get;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class    GetJugadorPorIdDTO {

    private Long id;
    private String nombre;
    private String posicion;
    private String debut;
    private String retiro;
    private List<ClubesDTO> clubes;
    private EstadisticasDTO estadisticas;

    @Data
    @NoArgsConstructor
    public static class ClubesDTO {
        Long id;
        String pais;
        Integer cantHinchas;
    }
    @Data
    @NoArgsConstructor
    public static class EstadisticasDTO {
        Long id;
        Integer cantidadGoles;
        Integer partidosJugados;
        String piernaHabil;
    }
}
