package com.grupoalemao.restaurante.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupoalemao.restaurante.Models.Cliente;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();//* arrumar para BD

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable int id) {
        if (id < 0 || id >= clientes.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientes.get(id), HttpStatus.OK);
    }
}
