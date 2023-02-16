package com.laurenmorgan.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurenmorgan.burgertracker.models.Burger;
import com.laurenmorgan.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
		
	}
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger b) {
		return burgerRepository.save(b);
	}
	
	public Burger findBurger(Long id) {
		
		Optional<Burger> burger = burgerRepository.findById(id);
		if (burger.isPresent()) {
			return burger.get();
		}
		else {
			return null;
		}
	}
		public Burger updateBurger(Burger burger) {
			return burgerRepository.save(burger);
		}
		
	    // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
		public void deleteBurger(Long id) {
			Optional<Burger> optionalBurger = burgerRepository.findById(id);
			if(optionalBurger.isPresent()) {
				burgerRepository.deleteById(id);
			}	
}
}
