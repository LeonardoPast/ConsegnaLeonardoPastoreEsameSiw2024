package com.uniroma3.esamesiw2024.controller;


import com.uniroma3.esamesiw2024.entity.Squadra;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import org.springframework.boot.Banner;
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

    @PostMapping("/add-player/{id}")
    ResponseEntity<SquadraDTO> addPlayerToSquadra(@PathVariable Long id, @RequestBody GiocatoreDTO giocatoreDTO);

    @GetMapping("/formPlayer/{idSquadra}")
    public String formPlayer(@PathVariable Long idSquadra, Model model);

    @PostMapping("/add-player-ui/{idSquadra}")
    public String addPlayerUi(@PathVariable Long idSquadra,@ModelAttribute(value = "giocatoreDTO") GiocatoreDTO giocatoreDTO);

    @GetMapping("/form-squadra-update-admin/{id}")
    public String formSquadraUpdate(@PathVariable Long id, Model model);

    @GetMapping("/get-squadra/{id}")
    public String getSquadraById(@PathVariable Long id, Model model);

    @GetMapping("/form-squadra-add")
    public String addSquadraForm(Model model);

    @PostMapping("/add-squadra")
    public String addSquadra(Model model, @ModelAttribute(value = "squadraDTO") SquadraDTO squadraDTO);

    @GetMapping("/get-presidente/{id}")
    public String findPresidenteForSquadra(@PathVariable Long id, Model model);

    @GetMapping("/add-presidente/{id}/{presidenteId}")
    public String addPresidenteToSquadra(@PathVariable Long id, @PathVariable Long presidenteId);

}
