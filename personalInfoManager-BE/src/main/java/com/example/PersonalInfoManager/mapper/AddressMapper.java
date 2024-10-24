package com.example.PersonalInfoManager.mapper;

import com.example.PersonalInfoManager.model.Address;
import com.example.PersonalInfoManager.model.DTO.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  AddressDTO toDto(Address address);

  Address toEntity(AddressDTO addressDTO);
}
