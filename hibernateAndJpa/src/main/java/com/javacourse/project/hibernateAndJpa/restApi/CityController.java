package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javacourse.project.hibernateAndJpa.Entities.*;
import com.javacourse.project.hibernateAndJpa.Business.ICityService;


@RestController
@RequestMapping("/api")
public class CityController {
	private ICityService cityService;

	
	// GET    : Veri görüntülemek istediğimiz zaman kullanılır.                @GetMapping
	// POST   : Veri kaydetmek istediğimiz zaman kullanılır.                   @PostMapping
	// PUT    : Veri güncellemek için kullanılır.			           @PutMapping
	// PATCH  : Verinin bir bölümünü güncellemek istediğimiz zaman kullanırız  @PatchMapping
        //		Örn: Parola güncellemek gibi
	// DELETE : Veri silmek istediğimiz zaman kullanırız                       @DeleteMapping

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){
		return cityService.getById(id);
	}
	
	
	
}
