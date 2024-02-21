package com.uniroma3.esamesiw2024.controller.impl;

import com.uniroma3.esamesiw2024.controller.SquadraController;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.PresidenteDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;
import com.uniroma3.esamesiw2024.service.GiocatoreService;
import com.uniroma3.esamesiw2024.service.PresidenteService;
import com.uniroma3.esamesiw2024.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class SquadraControllerImpl implements SquadraController {

    @Autowired
    private SquadraService service;

    @Autowired
    private PresidenteService presidenteService;

    @Autowired
    private GiocatoreService giocatoreService;

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

        List<SquadraDTO> listaDTO = new ArrayList<>();
        listaDTO = this.service.getAllSquadre();
        model.addAttribute("squadre", listaDTO);
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
    public String formPlayer(Long idSquadra, Model model) {
        SquadraDTO squadraDTO = this.service.getSquadraById(idSquadra);
        if(squadraDTO != null){
            model.addAttribute("squadraDTO", squadraDTO);
            model.addAttribute("giocatoreDTO", new GiocatoreDTO());
        }
        return "formPlayer";
    }

    @Override
    public String addPlayerUi(Long idSquadra, GiocatoreDTO giocatoreDTO) {
        SquadraDTO response = this.service.addPlayerToSquadra(idSquadra, giocatoreDTO);
        return "index";
    }

    @Override
    public String formSquadraUpdate(Long id, Model model) {
        SquadraDTO squadraDTO = new SquadraDTO();
        squadraDTO = this.service.getSquadraById(id);
        model.addAttribute("squadraDTO", squadraDTO);
        return "formSquadra";
    }

    @Override
    public String getSquadraById(Long id, Model model) {
        SquadraDTO squadraDTO = new SquadraDTO();
        squadraDTO = this.service.getSquadraById(id);
        //GiocatoreDTO giocatoreDTO = this.giocatoreService.ge
        model.addAttribute("squadraDTO", squadraDTO);
        if(squadraDTO.getPresidente() == null){
            model.addAttribute("presidente", "Presidente non assegnato");
            model.addAttribute("presidenti", this.presidenteService.getAllPresidente());
        }
        else{
            model.addAttribute("presidente", squadraDTO.getPresidente().getNome());
        }
        return "squadra";
    }

    @Override
    public String addSquadraForm(Model model) {
        model.addAttribute("squadraDTO", new SquadraDTO());
        return "aggiungiSquadra";
    }

    @Override
    public String addSquadra(Model model, SquadraDTO squadraDTO) {
        SquadraDTO response = this.service.insertSquadra(squadraDTO);
        model.addAttribute("squadra", response);
        return "squadra";
    }


    @Override
    public String findPresidenteForSquadra(Long id, Model model) {
        SquadraDTO squadraDTO = new SquadraDTO();
        squadraDTO = this.service.getSquadraById(id);
        model.addAttribute("squadraDTO", squadraDTO);
        List<PresidenteDTO> presidenteDTOList = new ArrayList<>();
        presidenteDTOList = this.presidenteService.getAllPresidente();
        model.addAttribute("presidenti", presidenteDTOList);
        return "presidenti";
    }

    @Override
    public String addPresidenteToSquadra(Long id, Long presidenteId) {
        SquadraDTO squadraDTO = new SquadraDTO();
        squadraDTO = this.service.addPresidenteToSquadra(id ,presidenteId);
        return "index";
    }
}
