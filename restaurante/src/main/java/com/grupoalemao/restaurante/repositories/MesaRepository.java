package com.grupoalemao.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupoalemao.restaurante.models.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
}