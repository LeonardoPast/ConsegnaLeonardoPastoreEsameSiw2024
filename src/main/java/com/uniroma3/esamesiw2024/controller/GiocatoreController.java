package com.uniroma3.esamesiw2024.controller;

import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RequestMapping("/giocatore")
public interface GiocatoreController {

    @GetMapping("/get-all-giocatore")
    ResponseEntity<List<GiocatoreDTO>> getAllGiocatore();

    @GetMapping("/get-all-giocatore-ui")
    public String getAllGiocatoreUi(Model model);
}
