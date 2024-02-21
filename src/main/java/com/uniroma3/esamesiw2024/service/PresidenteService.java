package com.uniroma3.esamesiw2024.service;

import com.uniroma3.esamesiw2024.entity.User;
import com.uniroma3.esamesiw2024.model.PresidenteDTO;

import java.util.List;

public interface PresidenteService {

    public List<PresidenteDTO> getAllPresidente();

    public PresidenteDTO savePresidente(User user);

    public PresidenteDTO findPresidenteByName(String nome);

    public PresidenteDTO getPresidenteById(Long id);
}
