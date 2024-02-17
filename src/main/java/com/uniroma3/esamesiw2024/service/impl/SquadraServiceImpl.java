package com.uniroma3.esamesiw2024.service.impl;

import com.uniroma3.esamesiw2024.entity.Giocatore;
import com.uniroma3.esamesiw2024.entity.Squadra;
import com.uniroma3.esamesiw2024.mapper.EntityUtil;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;
import com.uniroma3.esamesiw2024.repository.SquadraRepository;
import com.uniroma3.esamesiw2024.service.GiocatoreService;
import com.uniroma3.esamesiw2024.service.SquadraService;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class SquadraServiceImpl implements SquadraService {

    @Autowired
    private SquadraRepository repo;

    @Autowired
    private GiocatoreService giocatoreService;

    @Autowired
    private ModelMapper mapper;

    private Logger log = LogManager.getLogger();

    @Override
    public List<SquadraDTO> getAllSquadre() {
        List<Squadra> listaEntity = this.repo.findAll();
        return EntityUtil.mapList(this.mapper, SquadraDTO.class, listaEntity.toArray());
    }

    @Override
    public SquadraDTO insertSquadra(SquadraDTO squadraDTO) {
        Squadra squadraEntity = this.repo.save(mapper.map(squadraDTO, Squadra.class));
        return this.mapper.map(squadraEntity, SquadraDTO.class);
    }

    @Override
    public SquadraDTO updateSquadra(SquadraDTO squadraDTO, Long id) {
        SquadraDTO current = this.mapper.map(this.repo.findById(id).get(), SquadraDTO.class);

        if(squadraDTO.getDataFondazione() != null){
            current.setDataFondazione(squadraDTO.getDataFondazione());
        }
        if(squadraDTO.getIndirizzo() != null){
            current.setIndirizzo(squadraDTO.getIndirizzo());
        }
        if(squadraDTO.getNome() != null){
            current.setNome(squadraDTO.getNome());
        }

        this.repo.save(this.mapper.map(current, Squadra.class));
        return current;
    }

    @Override
    public SquadraDTO addPlayerToSquadra(Long id, GiocatoreDTO giocatoreDTO) {
        SquadraDTO current = this.mapper.map(this.repo.findById(id).get(), SquadraDTO.class);
        List<GiocatoreDTO> giocatoreList = current.getGiocatori();
        giocatoreList.add(giocatoreDTO);
        current.setGiocatori(giocatoreList);
        this.repo.save(this.mapper.map(current, Squadra.class));
        return current;
    }

    @Override
    public SquadraDTO getSquadraById(Long id) {
        Squadra squadraEntity = this.repo.findById(id).get();
        return this.mapper.map(squadraEntity, SquadraDTO.class);
    }
}
