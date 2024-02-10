package com.uniroma3.esamesiw2024.service;


import com.uniroma3.esamesiw2024.entity.Squadra;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;

import java.util.List;

public interface SquadraService {

    public List<SquadraDTO> getAllSquadre();

    public SquadraDTO insertSquadra(SquadraDTO squadraDTO);

    public SquadraDTO updateSquadra(SquadraDTO squadraDTO, Long id);

    public SquadraDTO addPlayerToSquadra(Long  id, GiocatoreDTO giocatoreDTO);
}
