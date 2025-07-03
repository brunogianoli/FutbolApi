package com.example.FutbolAPI.repositories;

import com.example.FutbolAPI.entities.EstadisticasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticaRepository extends JpaRepository<EstadisticasEntity, Long> {
}
