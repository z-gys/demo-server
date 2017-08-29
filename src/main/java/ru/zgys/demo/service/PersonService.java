package ru.zgys.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zgys.demo.dto.PersonDTO;
import ru.zgys.demo.mapper.PersonMapper;
import ru.zgys.demo.repository.PersonRepository;

import java.util.List;

/**
 * @author U.Goryntsev 29.08.2017
 */
@Service
public class PersonService {
	private final PersonRepository repository;
	private final PersonMapper mapper;

	@Autowired
	public PersonService(PersonRepository repository, PersonMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<Long> getPersonIds() {
		return repository.getPersonIds();
	}

	public Long createPerson(PersonDTO dto) {
		return repository.save(mapper.toEntity(dto)).getId();
	}
}
