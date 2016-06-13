package com.ingenia.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ingenia.boot.domain.Student;
import com.ingenia.boot.domain.StudentRepository;

@RestController
public class StudentController {

	@Autowired private StudentRepository repository;
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public Iterable<Student> getStudents(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/student", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student student){
		repository.save(student);
		return "Student add";
	}
	
	@RequestMapping(value="/student/{idStudent}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("idStudent") long idStudent){
		repository.delete(idStudent);
		return "Student deleted";
	}
	
	@RequestMapping(value="/student/{idStudent}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("idStudent") long idStudent){
		return repository.findOne(idStudent);
	}
}
