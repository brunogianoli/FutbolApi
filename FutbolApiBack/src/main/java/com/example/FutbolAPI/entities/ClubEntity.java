package com.example.FutbolAPI.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "club_entity")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    private String nombre;
    private String pais;

    private Integer cantHinchas;

    @ManyToMany(mappedBy = "clubes")
    private List<JugadorEntity> jugadores;
}

