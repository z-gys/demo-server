package ru.zgys.demo.exception;

/**
 * @author U.Goryntsev 30.08.2017
 */
public class PersonNotFoundException extends RuntimeException{
	public PersonNotFoundException(Long id) {
		super(String.format("Person with id: %d not found", id));
	}
}
