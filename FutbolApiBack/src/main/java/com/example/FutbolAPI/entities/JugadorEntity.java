package com.example.FutbolAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "jugador_entity")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nombre;
    private String posicion;
    private String debut;
    private String retiro;

    @ManyToMany
    @JoinTable(
            name = "jugador_club",
            joinColumns = @JoinColumn(name = "jugador_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<ClubEntity> clubes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadisticas_id")
    private EstadisticasEntity estadisticas;
}
