package com.laurenmorgan.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laurenmorgan.burgertracker.models.Burger;
import com.laurenmorgan.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
	
	
	@Autowired 
	BurgerService burgerService;
	
	
	
	@GetMapping("/burgers/new")
	public String newBurger(@ModelAttribute("burger") Burger burger, Model model) {
		List <Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		System.out.println(burgers);

		return "index.jsp";
	}
	
	
	@PostMapping("/burger")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
				List <Burger> burgers = burgerService.allBurgers();
				model.addAttribute("burgers", burgers);
		         return "index.jsp";
		        } else {
		        	burgerService.createBurger(burger);
		            return "redirect:/burgers/new";
		        }
	}
	
	@GetMapping("/burger/show")
	public String showPage() {
		return "show.jsp";
	}
	
	
	@RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		System.out.println(id);
        model.addAttribute("burger", burger );
        return "show.jsp";
    }
    
    @PostMapping(value="/burger/{id}")
    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "show.jsp";
        } else {
        	burgerService.updateBurger(burger);
            return "redirect:/burgers/new";
        }
    }
	}
