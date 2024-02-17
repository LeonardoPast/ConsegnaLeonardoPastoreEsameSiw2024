package com.uniroma3.esamesiw2024.controller;


import com.uniroma3.esamesiw2024.entity.Squadra;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.uniroma3.esamesiw2024.model.SquadraDTO;

import java.util.List;

@RequestMapping("/squadra")
public interface SquadraController {

    @GetMapping("/get-all-squadra-api")
    ResponseEntity<List<SquadraDTO>> getAllSquadra();

    @GetMapping("/get-all-squadra-ui")
    public String getAllSquadraUi(Model model);

    @PostMapping("/salva-squadra")
    ResponseEntity<SquadraDTO> insertSquadra(@RequestBody SquadraDTO squadraDTO);

    @PostMapping("/update-squadra/{id}")
    ResponseEntity<SquadraDTO> updateSquadra(@RequestBody SquadraDTO squadraDTO, @PathVariable Long id);

    @PostMapping("/update-squadra-ui/{id}")
    public String updateSquadraUi(@ModelAttribute(value = "squadraDTO") SquadraDTO squadraDTO, @PathVariable Long id);

    @PutMapping("/add-player/{id}")
    ResponseEntity<SquadraDTO> addPlayerToSquadra(@PathVariable Long id, @RequestBody GiocatoreDTO giocatoreDTO);

    @GetMapping("/form-squadra-update-admin/{id}")
    public String formSquadraUpdate(@PathVariable Long id, Model model);

}
