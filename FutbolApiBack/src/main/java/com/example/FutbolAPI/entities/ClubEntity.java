package com.example.FutbolAPI.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@CrossOrigin(origins = "http://localhost:4200")
@Table(name = "club_entity")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;
    private Integer cantHinchas;

    @OneToMany(mappedBy = "club")
    private List<JugadorEntity> jugadores;
}


