package com.uniroma3.esamesiw2024.service;

import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GiocatoreService {

    public GiocatoreDTO insertGiocatore(GiocatoreDTO giocatoreDTO);

    public List<GiocatoreDTO> getAllGiocatore();

    public GiocatoreDTO getGiocatore(Long id);
}
