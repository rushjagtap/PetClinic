package com.tus.petclinic.pet.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tus.petclinic.pet.entity.Pet;

@RestController
@RequestMapping(path = "/api/v1")
public class PetController {
	
	
	private final PetService petService;
	
	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	
	
	@RequestMapping(value = "/pets" ,method = RequestMethod.GET)
	public List<Pet> getAllPet()
	{
		return petService.getAllPet();
	}
	
	@RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
	public Optional<Pet> getPet(@PathVariable int id)
	{
		return petService.getPet(id);
	}
	
	
	
//	@RequestMapping(value = "/pet" ,method = RequestMethod.GET)
//	public List<Pet> getPetByName(@RequestParam String name)
//	{
//		return petService.getPet(name);
//	}
//	
	@RequestMapping(value ="/pets", method = RequestMethod.POST)
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet)
	{
		Pet savedPet = petService.addPet(pet);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/pets").buildAndExpand(savedPet.getId()).toUri();
		return new ResponseEntity<Pet>(savedPet,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/pets/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet pet)
	{
		Pet updatedPet = petService.updatePet(id, pet);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/pets").buildAndExpand(updatedPet.getId()).toUri();
		return new ResponseEntity<Pet>(updatedPet,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/pets/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pet> updatePet(@PathVariable int id)
	{
		System.out.println("start");
		Pet deletedPet = petService.deletePet(id);
		System.out.println("out");
		return new ResponseEntity<Pet>(deletedPet,HttpStatus.OK);
	}

}
