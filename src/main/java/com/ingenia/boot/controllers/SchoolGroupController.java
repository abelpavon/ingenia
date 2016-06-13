package com.ingenia.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ingenia.boot.domain.SchoolGroup;
import com.ingenia.boot.domain.SchoolGroupRepository;

@RestController
public class SchoolGroupController {
	
	 @Autowired private SchoolGroupRepository repository;
	
	/*@RequestMapping(value="/groups")
	@ResponseBody
	public String home(){
		return "Inside Groups";
	}*/
	
	@RequestMapping(value="/groups", method = RequestMethod.GET)
	public Iterable<SchoolGroup> getSchoolGroups(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/group", method = RequestMethod.POST)
	public String addSchoolGroup(@RequestBody SchoolGroup schoolGroup){
		repository.save(schoolGroup);
		return "Grupo agregado";
	}
	
	@RequestMapping(value="/group/{idGroup}", method = RequestMethod.DELETE)
	public String deleteSchoolGroup(@PathVariable("idGroup") long idGroup){
		repository.delete(idGroup);
		return "Group Deleted";
	}
	
	@RequestMapping(value="/group/{idGroup}", method = RequestMethod.GET)
	public SchoolGroup getGroup(@PathVariable("idGroup") long idGroup){
		return repository.findOne(idGroup);
	}
}
