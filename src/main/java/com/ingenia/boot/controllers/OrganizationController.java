package com.ingenia.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ingenia.boot.domain.Organization;
import com.ingenia.boot.domain.OrganizationRepository;


@RestController
public class OrganizationController {

	@Autowired private OrganizationRepository repository;
	
	@RequestMapping(value="/organizations", method = RequestMethod.GET)
	public Iterable<Organization> getOrganizations(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/organization", method = RequestMethod.POST)
	public String addOrganization(@RequestBody Organization organization){
		repository.save(organization);
		return "Organization add";
	}
	
	@RequestMapping(value="/organization/{idOrganization}", method = RequestMethod.DELETE)
	public String deleteOrganization(@PathVariable("idOrganization") long idOrganization){
		repository.delete(idOrganization);
		return "Organization deleted";
	}
	
	@RequestMapping(value="/organization/{idOrganization}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable("idOrganization") long idOrganization){
		return repository.findOne(idOrganization);
	}
}
