package com.grupoalemao.restaurante.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.grupoalemao.restaurante.Models.Mesa;
import com.grupoalemao.restaurante.Repositories.MesaRepository;

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

    
    
    
}

