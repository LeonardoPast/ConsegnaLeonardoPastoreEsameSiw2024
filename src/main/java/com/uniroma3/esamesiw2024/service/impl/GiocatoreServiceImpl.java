package com.uniroma3.esamesiw2024.service.impl;

import com.uniroma3.esamesiw2024.entity.Giocatore;
import com.uniroma3.esamesiw2024.entity.Squadra;
import com.uniroma3.esamesiw2024.mapper.EntityUtil;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;
import com.uniroma3.esamesiw2024.repository.GiocatoreRepository;
import com.uniroma3.esamesiw2024.service.GiocatoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiocatoreServiceImpl implements GiocatoreService {

    @Autowired
    private GiocatoreRepository repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GiocatoreDTO insertGiocatore(GiocatoreDTO giocatoreDTO) {
        Giocatore giocatoreEntity = this.repo.save(mapper.map(giocatoreDTO, Giocatore.class));
        return this.mapper.map(giocatoreEntity, GiocatoreDTO.class);
    }

    @Override
    public List<GiocatoreDTO> getAllGiocatore() {
        List<Giocatore> listaEntity = this.repo.findAll();
        return EntityUtil.mapList(this.mapper, GiocatoreDTO.class, listaEntity.toArray());
    }
}
