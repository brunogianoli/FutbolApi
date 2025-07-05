package com.example.FutbolAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jugador_entity")
@CrossOrigin(origins = "http://localhost:4200")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String posicion;
    private String debut;
    private String retiro;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubEntity club;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadisticas_id")
    private EstadisticasEntity estadisticas;
}

