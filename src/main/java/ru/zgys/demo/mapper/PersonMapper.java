package ru.zgys.demo.mapper;

import org.mapstruct.Mapper;
import ru.zgys.demo.domain.Person;
import ru.zgys.demo.dto.PersonDTO;

/**
 * @author U.Goryntsev 29.08.2017
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

	Person toEntity(PersonDTO dto);
}
