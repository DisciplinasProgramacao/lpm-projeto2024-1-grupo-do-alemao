package com.grupoalemao.restaurante.Controllers;

import com.grupoalemao.restaurante.Models.*;
import com.grupoalemao.restaurante.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class RequisicaoReservaController {

    @Autowired
    private RequisicaoReservaRepository requisicaoReservaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Retorna todas as reservas existentes.
     *
     * @return Lista de todas as reservas
     */
    @GetMapping
    public List<RequisicaoReserva> getAllReservas() {
        return requisicaoReservaRepository.findAll();
    }

    /**
     * Retorna uma reserva pelo ID.
     *
     * @param id ID da reserva a ser buscada
     * @return Resposta com a reserva encontrada ou status 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<RequisicaoReserva> getReservaById(@PathVariable Integer id) {
        return requisicaoReservaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova reserva.
     *
     * @param requisicaoReserva Objeto da nova reserva a ser criada
     * @return A reserva criada
     */
    @PostMapping
    public RequisicaoReserva createReserva(@RequestBody RequisicaoReserva requisicaoReserva) {
        return requisicaoReservaRepository.save(requisicaoReserva);
    }

    /**
     * Adiciona um produto a uma reserva existente.
     *
     * @param reservaId ID da reserva à qual o produto será adicionado
     * @param produtoId ID do produto a ser adicionado à reserva
     * @return Resposta com a reserva atualizada ou status 404 se reserva ou produto
     *         não encontrados
     */
    @PutMapping("/{reservaId}/addProduto/{produtoId}")
    public ResponseEntity<RequisicaoReserva> addProdutoToReserva(@PathVariable Integer reservaId,
            @PathVariable Integer produtoId) {

        var optionalReserva = requisicaoReservaRepository.findById(reservaId);
        if (optionalReserva.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Long produtoIdLong = produtoId.longValue();
        var optionalProduto = produtoRepository.findById(produtoIdLong);
        if (optionalProduto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RequisicaoReserva reserva = optionalReserva.get();
        Produto produto = optionalProduto.get();
        reserva.addProdutoAPedido(produto);

        requisicaoReservaRepository.save(reserva);

        return ResponseEntity.ok(reserva);
    }

    /**
     * Encerra uma reserva pelo ID.
     *
     * @param id ID da reserva a ser encerrada
     * @return Resposta com a reserva encerrada ou status 404 se a reserva não for
     *         encontrada
     */
    @PutMapping("/encerrar/{id}")
    public ResponseEntity<RequisicaoReserva> encerrarReserva(@PathVariable Integer id) {
        return requisicaoReservaRepository.findById(id)
                .map(reserva -> {
                    reserva.cancelar();
                    requisicaoReservaRepository.save(reserva);
                    return ResponseEntity.ok(reserva);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
