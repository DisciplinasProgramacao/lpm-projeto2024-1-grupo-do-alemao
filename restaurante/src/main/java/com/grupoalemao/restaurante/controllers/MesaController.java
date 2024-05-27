package com.grupoalemao.restaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.grupoalemao.restaurante.models.Mesa;
import com.grupoalemao.restaurante.repositories.MesaRepository;

/**
 * Controlador REST para gerenciar mesas no restaurante.
 */
@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    /**
     * Retorna a lista de todas as mesas.
     * @return uma lista de todas as mesas.
     */
    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    /**
     * Retorna uma mesa específica com base no ID fornecido.
     * @param id o ID da mesa a ser retornada.
     * @return a mesa com o ID fornecido ou uma resposta de não encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Integer id) {
        return mesaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova mesa.
     * @param mesa o objeto Mesa a ser criado.
     * @return a mesa criada.
     */
    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    /**
     * Atualiza uma mesa existente com base no ID fornecido.
     * @param id o ID da mesa a ser atualizada.
     * @param mesaDetails o objeto Mesa com os detalhes atualizados.
     * @return a mesa atualizada ou uma resposta de não encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable Integer id, @RequestBody Mesa mesaDetails) {
        return mesaRepository.findById(id)
                .map(mesa -> {
                    mesa.setCapacidade(mesaDetails.getCapacidade());
                    mesa.setCliente(mesaDetails.getCliente());
                    mesa.setDisponivel(mesaDetails.isDisponivel());
                    Mesa updatedMesa = mesaRepository.save(mesa);
                    return ResponseEntity.ok(updatedMesa);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Deleta uma mesa com base no ID fornecido.
     * @param id o ID da mesa a ser deletada.
     * @return uma resposta OK se a mesa for deletada ou uma resposta de não encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMesa(@PathVariable Integer id) {
        return mesaRepository.findById(id)
                .map(mesa -> {
                    mesaRepository.delete(mesa);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
