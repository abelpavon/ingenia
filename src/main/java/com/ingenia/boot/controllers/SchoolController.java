package com.ingenia.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ingenia.boot.domain.School;
import com.ingenia.boot.domain.SchoolRepository;

@RestController
public class SchoolController {

	@Autowired
	private SchoolRepository repository;

	@RequestMapping(value = "/")
	@ResponseBody
	public String home() {
		return "Spring Boot";
	}

	@RequestMapping(value = "/schools", method = RequestMethod.GET)
	public Iterable<School> schools() {
		return repository.findAll();
	}

	@RequestMapping(value = "/schools/{idEscuela}", method = RequestMethod.GET)
	public School encontrarEscuela(@PathVariable("idEscuela") long idEscuela) {
		return repository.findOne(idEscuela);
	}

	@RequestMapping(value = "/schools/{idEscuela}", method = RequestMethod.DELETE)
	public String eliminarEscuela(@PathVariable("idEscuela") long idEscuela) {
		repository.delete(idEscuela);
		return "Escuela eliminada";
	}
	
	@RequestMapping(value = "/schools",method = RequestMethod.POST)
	public String agregarEscuela(@RequestBody School school) {
		repository.save(school);
		return "Escuela agregada";
	}
}
