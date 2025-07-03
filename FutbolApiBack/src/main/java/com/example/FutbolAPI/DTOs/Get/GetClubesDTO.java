package com.example.FutbolAPI.DTOs.Get;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetClubesDTO {
    String nombre;
    String pais;
    Integer cantHinchas;
}
