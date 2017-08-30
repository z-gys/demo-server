package ru.zgys.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.zgys.demo.domain.Person;

import java.util.List;

/**
 * @author U.Goryntsev 29.08.2017
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT p.id FROM Person p WHERE p.active = true ")
	List<Long> getPersonIds();

	Person findByActiveTrueAndId(Long id);
}
