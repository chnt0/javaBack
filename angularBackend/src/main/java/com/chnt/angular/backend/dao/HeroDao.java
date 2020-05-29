package com.chnt.angular.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.chnt.angular.backend.model.Hero;

public interface HeroDao extends CrudRepository<Hero, Long>{
	
	public Hero findByName(String name);

}
