package com.example.FutbolAPI.repositories;

import com.example.FutbolAPI.entities.EstadisticasEntity;
import com.example.FutbolAPI.entities.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorEntity, Long> {

}
