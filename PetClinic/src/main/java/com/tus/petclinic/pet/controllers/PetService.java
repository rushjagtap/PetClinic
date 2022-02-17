package com.tus.petclinic.pet.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tus.petclinic.pet.dao.PetRepository;
import com.tus.petclinic.pet.entity.Pet;

@Service
public class PetService {
	
	private final PetRepository petRepository;
	
	@Autowired
	public PetService(PetRepository PetRepo)
	{
		this.petRepository = PetRepo;
	}
	
	public List<Pet> getAllPet()
	{
		return petRepository.findAll();
	}
	
	public Optional<Pet> getPet(int id)
	{
		return petRepository.findById(id);
	}
	
	public List<Pet> getPet(String name)
	{
		return petRepository.findByName(name);
	}
	
	public Pet addPet(Pet pet)
	{
		return petRepository.save(pet);
	}
	
	public Pet deletePet(int id)
	{
		System.out.println("test");
		Optional<Pet> optionalPet = petRepository.findById(id);
		System.out.println(optionalPet);
		Pet existingPet = optionalPet.get();
		petRepository.deleteById(id);
		return existingPet;
	}
	
	public Pet updatePet(int id, Pet pet)
	{
		Optional<Pet> optionalPet = petRepository.findById(id);
		
		Pet existingPet = optionalPet.get();
		existingPet.setBirthdate(pet.getBirthdate());
		existingPet.setName(pet.getName());
		existingPet.setType(pet.getType());
		existingPet.setVisits(pet.getVisits());
		
		return petRepository.save(existingPet);
	}

}
