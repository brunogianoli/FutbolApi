package com.example.FutbolAPI.DTOs.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostJugadorDTO {

    String nombre;
    String posicion;
    String debut;
    List<ClubesDTO> clubes;
    EstadisticasDTO estadisticasDTO;


    public static class ClubesDTO{
        Long id;
    }

    public static class EstadisticasDTO{
        Integer cantGoles;
        Integer partidosJugados;
        String piernaHabil;

    }


}
