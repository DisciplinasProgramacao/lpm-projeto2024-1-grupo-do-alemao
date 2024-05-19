package com.grupoalemao.restaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.grupoalemao.restaurante.models.Mesa;
import com.grupoalemao.restaurante.repositories.MesaRepository;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Integer id) {
        return mesaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa) {
        return mesaRepository.save(mesa);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMesa(@PathVariable Integer id) {
        return mesaRepository.findById(id)
                .map(mesa -> {
                    mesaRepository.delete(mesa);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
