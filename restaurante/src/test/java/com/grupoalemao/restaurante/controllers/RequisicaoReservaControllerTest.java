package com.grupoalemao.restaurante.controllers;

import com.grupoalemao.restaurante.models.*;
import com.grupoalemao.restaurante.repositories.RequisicaoReservaRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RequisicaoReservaController.class)
public class RequisicaoReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequisicaoReservaRepository requisicaoReservaRepository;

    @Test
    public void testGetAllReservas() throws Exception {
        Mesa mesa1 = new Mesa(1, 4, true, null);
        Mesa mesa2 = new Mesa(2, 6, true, null);
        RequisicaoReserva reserva1 = new RequisicaoReserva(LocalDate.now(), 4, new Cliente(), mesa1);
        RequisicaoReserva reserva2 = new RequisicaoReserva(LocalDate.now().plusDays(1), 2, new Cliente(), mesa2);
        when(requisicaoReservaRepository.findAll()).thenReturn(Arrays.asList(reserva1, reserva2));

        mockMvc.perform(get("/reservas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pessoas").value(4))
                .andExpect(jsonPath("$[1].pessoas").value(2));
    }

    @Test
    public void testGetReservaById() throws Exception {
        Mesa mesa = new Mesa(1, 4, true, null);
        RequisicaoReserva reserva = new RequisicaoReserva(LocalDate.now(), 4, new Cliente(), mesa);
        when(requisicaoReservaRepository.findById(1)).thenReturn(Optional.of(reserva));

        mockMvc.perform(get("/reservas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pessoas").value(4));
    }

    @Test
    public void testCreateReserva() throws Exception {
        Mesa mesa = new Mesa(1, 4, true, null);
        RequisicaoReserva reserva = new RequisicaoReserva(LocalDate.now(), 4, new Cliente(), mesa);
        when(requisicaoReservaRepository.save(any(RequisicaoReserva.class))).thenReturn(reserva);

        mockMvc.perform(post("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dataReserva\": \"" + LocalDate.now() + "\", \"pessoas\": 4, \"ativa\": true, \"cliente\": null, \"mesa\": {\"cod\": 1, \"capacidade\": 4, \"disponivel\": true}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pessoas").value(4));
    }

    @Test
    public void testUpdateReserva() throws Exception {
        Mesa mesa = new Mesa(1, 4, true, null);
        RequisicaoReserva existingReserva = new RequisicaoReserva(LocalDate.now(), 4, new Cliente(), mesa);
        RequisicaoReserva updatedReserva = new RequisicaoReserva(LocalDate.now(), 6, new Cliente(), mesa);
        when(requisicaoReservaRepository.findById(1)).thenReturn(Optional.of(existingReserva));
        when(requisicaoReservaRepository.save(any(RequisicaoReserva.class))).thenReturn(updatedReserva);

        mockMvc.perform(put("/reservas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dataReserva\": \"" + LocalDate.now() + "\", \"pessoas\": 6, \"ativa\": true, \"cliente\": null, \"mesa\": {\"cod\": 1, \"capacidade\": 4, \"disponivel\": true}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pessoas").value(6));
    }

    @Test
    public void testDeleteReserva() throws Exception {
        Mesa mesa = new Mesa(1, 4, true, null);
        RequisicaoReserva reserva = new RequisicaoReserva(LocalDate.now(), 4, new Cliente(), mesa);
        when(requisicaoReservaRepository.findById(1)).thenReturn(Optional.of(reserva));

        mockMvc.perform(delete("/reservas/1"))
                .andExpect(status().isOk());
    }
}
