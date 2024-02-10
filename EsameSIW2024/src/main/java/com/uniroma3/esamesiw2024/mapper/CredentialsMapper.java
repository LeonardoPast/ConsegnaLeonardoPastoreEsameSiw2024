package com.uniroma3.esamesiw2024.mapper;

import com.uniroma3.esamesiw2024.entity.Credentials;
import com.uniroma3.esamesiw2024.model.CredentialsDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CredentialsMapper {

    Credentials DTOToEntity(CredentialsDTO dto);

    CredentialsDTO entityToDTO(Credentials entity);
}
