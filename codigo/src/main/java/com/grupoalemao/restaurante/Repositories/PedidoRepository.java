package com.grupoalemao.restaurante.Repositories;

import com.grupoalemao.restaurante.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
