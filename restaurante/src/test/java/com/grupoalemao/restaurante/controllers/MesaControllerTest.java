package com.grupoalemao.restaurante.controllers;

import com.grupoalemao.restaurante.models.Mesa;
import com.grupoalemao.restaurante.repositories.MesaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MesaController.class)
public class MesaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MesaRepository mesaRepository;

    @Test
    public void testGetAllMesas() throws Exception {
        System.out.println("Teste para obter todas as mesas");

        Mesa mesa1 = new Mesa(1, 4, true, null);
        Mesa mesa2 = new Mesa(2, 6, false, null);
        when(mesaRepository.findAll()).thenReturn(Arrays.asList(mesa1, mesa2));

        mockMvc.perform(get("/mesas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cod").value(1))
                .andExpect(jsonPath("$[0].capacidade").value(4))
                .andExpect(jsonPath("$[1].cod").value(2))
                .andExpect(jsonPath("$[1].capacidade").value(6));

        System.out.println("Teste para obter todas as mesas concluído com sucesso");
    }

    @Test
    public void testGetMesaById() throws Exception {
        System.out.println("Teste para obter mesa por ID");

        Mesa mesa = new Mesa(1, 4, true, null);
        when(mesaRepository.findById(1)).thenReturn(Optional.of(mesa));

        mockMvc.perform(get("/mesas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cod").value(1))
                .andExpect(jsonPath("$.capacidade").value(4));

        System.out.println("Teste para obter mesa por ID concluído com sucesso");
    }

    @Test
    public void testCreateMesa() throws Exception {
        System.out.println("Teste para criar uma nova mesa");

        Mesa mesa = new Mesa(1, 4, true, null);
        when(mesaRepository.save(any(Mesa.class))).thenReturn(mesa);

        mockMvc.perform(post("/mesas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cod\": 1, \"capacidade\": 4, \"disponivel\": true, \"cliente\": null}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cod").value(1))
                .andExpect(jsonPath("$.capacidade").value(4));

        System.out.println("Teste para criar uma nova mesa concluído com sucesso");
    }

    @Test
    public void testUpdateMesa() throws Exception {
        System.out.println("Teste para atualizar uma mesa");

        Mesa existingMesa = new Mesa(1, 4, true, null);
        Mesa updatedMesa = new Mesa(1, 6, false, null);
        when(mesaRepository.findById(1)).thenReturn(Optional.of(existingMesa));
        when(mesaRepository.save(any(Mesa.class))).thenReturn(updatedMesa);

        mockMvc.perform(put("/mesas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cod\": 1, \"capacidade\": 6, \"disponivel\": false, \"cliente\": null}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cod").value(1))
                .andExpect(jsonPath("$.capacidade").value(6))
                .andExpect(jsonPath("$.disponivel").value(false));

        System.out.println("Teste para atualizar uma mesa concluído com sucesso");
    }

    @Test
    public void testDeleteMesa() throws Exception {
        System.out.println("Teste para deletar uma mesa");

        Mesa mesa = new Mesa(1, 4, true, null);
        when(mesaRepository.findById(1)).thenReturn(Optional.of(mesa));

        mockMvc.perform(delete("/mesas/1"))
                .andExpect(status().isOk());

        System.out.println("Teste para deletar uma mesa concluído com sucesso");
    }
}
