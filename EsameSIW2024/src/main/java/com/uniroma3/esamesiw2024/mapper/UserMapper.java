package com.uniroma3.esamesiw2024.mapper;

import com.uniroma3.esamesiw2024.entity.User;
import com.uniroma3.esamesiw2024.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User DTOToEntity(UserDTO dto);

    UserDTO entityToDTO(User entity);

}
