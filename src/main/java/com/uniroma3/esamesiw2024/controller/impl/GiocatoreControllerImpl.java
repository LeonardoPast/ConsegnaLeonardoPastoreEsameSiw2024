package com.uniroma3.esamesiw2024.controller.impl;

import com.uniroma3.esamesiw2024.controller.GiocatoreController;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;
import com.uniroma3.esamesiw2024.service.GiocatoreService;
import com.uniroma3.esamesiw2024.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GiocatoreControllerImpl implements GiocatoreController {

    @Autowired
    private GiocatoreService service;

    @Override
    public ResponseEntity<List<GiocatoreDTO>> getAllGiocatore() {
        List<GiocatoreDTO> listaDTO = this.service.getAllGiocatore();
        if(listaDTO != null && !listaDTO.isEmpty()){
            return new ResponseEntity<List<GiocatoreDTO>>(listaDTO, HttpStatus.OK);
        }
        return new ResponseEntity<List<GiocatoreDTO>>(HttpStatus.NOT_FOUND);
    }
}
