package com.uniroma3.esamesiw2024.controller.impl;

import com.uniroma3.esamesiw2024.controller.SquadraController;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;
import com.uniroma3.esamesiw2024.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class SquadraControllerImpl implements SquadraController {

    @Autowired
    private SquadraService service;

    @Override
    public ResponseEntity<List<SquadraDTO>> getAllSquadra() {
        List<SquadraDTO> listaDTO = this.service.getAllSquadre();
        if(listaDTO != null && !listaDTO.isEmpty()){
            return new ResponseEntity<List<SquadraDTO>>(listaDTO, HttpStatus.OK);
        }
        return new ResponseEntity<List<SquadraDTO>>(HttpStatus.NOT_FOUND);
    }

    @Override
    public String getAllSquadraUi(Model model) {
        List<SquadraDTO> listaDTO = this.service.getAllSquadre();
        if(listaDTO != null && !listaDTO.isEmpty()){
            model.addAttribute("squadre", listaDTO);
        }
        return "squadre";
    }

    @Override
    public ResponseEntity<SquadraDTO> insertSquadra(SquadraDTO squadraDTO) {
        SquadraDTO response = this.service.insertSquadra(squadraDTO);

        if(response != null){
            return new ResponseEntity<SquadraDTO>(response, HttpStatus.OK);
        }
        return new ResponseEntity<SquadraDTO>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<SquadraDTO> updateSquadra(SquadraDTO squadraDTO, Long id) {
        SquadraDTO response = this.service.updateSquadra(squadraDTO, id);
        if(response != null){
            return new ResponseEntity<SquadraDTO>(response, HttpStatus.OK);
        }
        return new ResponseEntity<SquadraDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public String updateSquadraUi(SquadraDTO squadraDTO, Long id){
        SquadraDTO response = this.service.updateSquadra(squadraDTO, id);
        if(response != null){
            //return "successUpdate";
            return "index";
        }
        return "error";
    }

    @Override
    public ResponseEntity<SquadraDTO> addPlayerToSquadra(Long id, GiocatoreDTO giocatoreDTO) {
        SquadraDTO response = this.service.addPlayerToSquadra(id, giocatoreDTO);
        if(response != null){
            return new ResponseEntity<SquadraDTO>(response, HttpStatus.OK);
        }
        return new ResponseEntity<SquadraDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String formSquadraUpdate(Long id, Model model) {
        SquadraDTO squadraDTO = this.service.getSquadraById(id);
        if(squadraDTO != null){
            model.addAttribute("squadraDTO", squadraDTO);
        }
        return "formSquadra";
    }
}
