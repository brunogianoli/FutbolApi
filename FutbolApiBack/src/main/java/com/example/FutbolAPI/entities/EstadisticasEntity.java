package com.example.FutbolAPI.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estadisticas_entity")
public class EstadisticasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "goles")
    Integer CantidadGoles;

    @Column(name = "partidos_jugados")
    Integer PartidosJugados;

    @Column(name = "pierna_habil")
    String PiernaHabil;
}
