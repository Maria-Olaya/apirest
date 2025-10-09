package com.proyecto.cabapro.controller;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cabapro.model.Torneo;
import com.proyecto.cabapro.service.PartidoService;
import com.proyecto.cabapro.service.TorneoService;

@Controller
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;
    private final TorneoService torneoService;

    public PartidoController(PartidoService partidoService,
                             TorneoService torneoService)
                              {
        this.partidoService = partidoService;
        this.torneoService = torneoService;
        
    }


    // Helpers
    private void cargarListas(Model model) {
        // Torneos activos = fechaFin > ahora
        List<Torneo> torneosActivos = torneoService.listarTorneos()
                .stream()
                .filter(t -> t.getFechaFin() != null && t.getFechaFin().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
        model.addAttribute("torneos", torneosActivos);

    }
}
