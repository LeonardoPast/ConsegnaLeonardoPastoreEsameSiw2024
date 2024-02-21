package com.uniroma3.esamesiw2024.service.impl;

import com.uniroma3.esamesiw2024.entity.Giocatore;
import com.uniroma3.esamesiw2024.entity.Presidente;
import com.uniroma3.esamesiw2024.entity.Squadra;
import com.uniroma3.esamesiw2024.entity.User;
import com.uniroma3.esamesiw2024.mapper.EntityUtil;
import com.uniroma3.esamesiw2024.model.GiocatoreDTO;
import com.uniroma3.esamesiw2024.model.PresidenteDTO;
import com.uniroma3.esamesiw2024.model.SquadraDTO;
import com.uniroma3.esamesiw2024.repository.PresidenteRepository;
import com.uniroma3.esamesiw2024.service.PresidenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresidenteServiceImpl implements PresidenteService {


    @Autowired
    PresidenteRepository presidenteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PresidenteDTO> getAllPresidente() {
        List<Presidente> listaEntity = this.presidenteRepository.findAll();
        return EntityUtil.mapList(this.mapper, PresidenteDTO.class, listaEntity.toArray());
    }

    @Override
    public PresidenteDTO savePresidente(User user) {
        PresidenteDTO presidenteDTO = new PresidenteDTO();
        presidenteDTO.setNome(user.getName());
        presidenteDTO.setCognome(user.getSurname());
        Presidente presidente = this.presidenteRepository.save(mapper.map(presidenteDTO, Presidente.class));

        return this.mapper.map(presidente, PresidenteDTO.class);
    }

    @Override
    public PresidenteDTO findPresidenteByName(String nome) {
        Presidente presidente = presidenteRepository.findByNome(nome);
        return this.mapper.map(presidente, PresidenteDTO.class);
    }

    @Override
    public PresidenteDTO getPresidenteById(Long id) {
        Presidente presidente = presidenteRepository.findById(id).get();
        return this.mapper.map(presidente, PresidenteDTO.class);
    }
}
