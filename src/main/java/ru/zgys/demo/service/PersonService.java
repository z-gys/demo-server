package ru.zgys.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zgys.demo.domain.Person;
import ru.zgys.demo.dto.PersonDTO;
import ru.zgys.demo.exception.PersonNotFoundException;
import ru.zgys.demo.mapper.PersonMapper;
import ru.zgys.demo.repository.PersonRepository;

import javax.transaction.Transactional;
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

	@Transactional
	public void updatePerson(Long id, PersonDTO dto) {
		Person person = repository.findByActiveTrueAndId(id);
		if (person == null)
			person = new Person();

		mapper.updateEntity(person, dto);
		repository.save(person);
	}

	public PersonDTO getPerson(Long id) {
		Person person = repository.findByActiveTrueAndId(id);
		if (person == null)
			throw new PersonNotFoundException(id);

		return mapper.toDto(person);
	}

	@Transactional
	public void deactivatePerson(Long id) {
		Person person = repository.findByActiveTrueAndId(id);
		if (person == null)
			return;

		person.setActive(false);
		repository.save(person);
	}
}
