package com.grupoalemao.restaurante.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.grupoalemao.exceptions.GlobalExceptions;
import java.util.ArrayList;

public class Restaurante {

    static List<Mesa> mesas = new ArrayList<>();
    FilaDeEspera filaDeEspera = new FilaDeEspera();
    List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(String nome) throws GlobalExceptions {
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
    }

    public void removerCliente(String nome) {
        clientes = clientes.stream()
                .filter(cliente -> !cliente.getNome().equals(nome))
                .collect(Collectors.toList());
    }

    public void adicionarMesa(int cod, int capacidade, boolean disponivel, Cliente cliente) {
        Mesa mesa = new Mesa(cod, capacidade, disponivel, cliente);
        mesas.add(mesa);
    }

    public void removerMesa(int cod) {
        mesas = mesas.stream()
                .filter(mesa -> mesa.getCod() != cod)
                .collect(Collectors.toList());
    }

    public void alocarMesa(RequisicaoReserva requisicao) {
        int pessoas = requisicao.getPessoas();
        Optional<Mesa> mesaOptional = mesas.stream()
                .filter(mesa -> mesa.getCod() == requisicao.getMesa().getCod() && mesa.estaDisponivel(pessoas))
                .findFirst();

        if (mesaOptional.isPresent()) {
            Mesa mesa = mesaOptional.get();
            mesa.mudarStatusMesa(requisicao.getCliente());
            mesa.setDisponivel(false);
            mesa.setCliente(requisicao.getCliente());
        } else {
            filaDeEspera.addRequisicaoNaFila(requisicao);
        }
    }

    public void liberarMesa(int codMesa) {
        mesas.stream()
                .filter(mesa -> mesa.getCod() == codMesa && !mesa.estaDisponivel(0))
                .findFirst()
                .ifPresent(mesa -> {
                    mesa.mudarStatusMesa(null);
                    mesa.liberar();
                });
    }

    public static void inicializaMesas() {
        mesas.add(new Mesa(1, 4, true, null));
        mesas.add(new Mesa(2, 4, true, null));
        mesas.add(new Mesa(3, 4, true, null));
        mesas.add(new Mesa(4, 4, true, null));
        mesas.add(new Mesa(5, 6, true, null));
        mesas.add(new Mesa(6, 6, true, null));
        mesas.add(new Mesa(7, 6, true, null));
        mesas.add(new Mesa(8, 6, true, null));
        mesas.add(new Mesa(9, 8, true, null));
        mesas.add(new Mesa(10, 8, true, null));
    }

    public Mesa getMesaByCodigo(int codigo) {
        return mesas.stream()
                .filter(mesa -> mesa.getCod() == codigo)
                .findFirst()
                .orElse(null);
    }
}
