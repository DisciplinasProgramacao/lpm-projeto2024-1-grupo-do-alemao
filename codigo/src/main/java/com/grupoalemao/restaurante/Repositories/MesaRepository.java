package com.grupoalemao.restaurante.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupoalemao.restaurante.Models.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
}
