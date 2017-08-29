package ru.zgys.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.zgys.demo.dto.PersonDTO;
import ru.zgys.demo.service.PersonService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author U.Goryntsev 29.08.2017
 */
@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class PersonResource {

	private final PersonService service;

	@Autowired
	public PersonResource(PersonService service) {
		this.service = service;
	}

	@RequestMapping("person")
	public ResponseEntity<List<Long>> getPersons() {
		return ResponseEntity.ok(service.getPersonIds());
	}

	@RequestMapping(value = "person", method = POST)
	public ResponseEntity<Void> createPerson(@RequestBody PersonDTO dto) {
		return ResponseEntity.created(URI.create("/person/" + service.createPerson(dto))).build();
	}
}
