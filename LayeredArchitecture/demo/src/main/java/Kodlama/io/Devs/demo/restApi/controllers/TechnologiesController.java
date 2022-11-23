package Kodlama.io.Devs.demo.restApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Kodlama.io.Devs.demo.business.abstracts.TechnologiesService;
import Kodlama.io.Devs.demo.business.requests.technologies.CreateTechnologiesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.DeleteTechnologiesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.UpdateTechnologiesRequest;
import Kodlama.io.Devs.demo.business.responses.technologies.GetAllTechnologiesResponse;
import Kodlama.io.Devs.demo.business.responses.technologies.GetByIdTechnologiesResponse;
import Kodlama.io.Devs.demo.entities.Technologies;
import Kodlama.io.Devs.demo.entities.Languages;


@RestController
@RequestMapping("/api/tech")
public class TechnologiesController {
	private TechnologiesService technologiesService;
	
	@Autowired
	public TechnologiesController(TechnologiesService technologiesService) {
		this.technologiesService = technologiesService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getall(){
		return technologiesService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public GetByIdTechnologiesResponse getbyid(@PathVariable int id) throws Exception{
		return technologiesService.findById(id);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteTechnologiesRequest deleteTechnologiesResponse) throws Exception{
		technologiesService.delete(deleteTechnologiesResponse);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateTechnologiesRequest createTechnologiesRequest) throws Exception{
		technologiesService.add(createTechnologiesRequest);
	}
	
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateTechnologiesRequest updateTechnologiesRequest) throws Exception{
		technologiesService.update(updateTechnologiesRequest);
	}
	
	
	
}
