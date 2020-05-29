package com.chnt.angular.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chnt.angular.backend.dao.HeroDao;
import com.chnt.angular.backend.model.Hero;

@RestController(value = "heroes")
public class HeroController {
	
	@Autowired
	private HeroDao dao;
	
	@GetMapping("/all")
	public List<Hero> getHeroes(){
		List<Hero> result= new ArrayList<Hero>(); 
		 dao.findAll().forEach(a->result.add(a));
		 return result;
	}
	@GetMapping("/")
	public String getHeroesh(){
		 return "hola mundo";
	}
	
	@GetMapping("/select/{id}")
	public Hero getHeroeById(@PathVariable Long id){
		 return dao.findById(id).orElse(null);
	}
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Hero save(@RequestBody Hero hero) {
		return dao.save(hero);
	}
	
	@GetMapping("/select/byname/{name}")
	public Hero heroName(@PathVariable String name) {
		return dao.findByName(name);
		
	}
	
	
	

}
