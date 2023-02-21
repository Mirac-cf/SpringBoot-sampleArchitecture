package Kodlama.io.Devs.demo.restApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.demo.business.abstracts.LanguagesService;
import Kodlama.io.Devs.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.DeleteLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.Devs.demo.business.responses.languages.GetAllLanguagesResponse;
import Kodlama.io.Devs.demo.business.responses.languages.GetByIdLanguagesResponse;

@RestController
@RequestMapping("/api/language")
public class LanguagesController {
	
	private LanguagesService languagesService;
	
	
	@Autowired
	public LanguagesController(LanguagesService lessonService) {
		this.languagesService = lessonService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return languagesService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public GetByIdLanguagesResponse getbyid(@PathVariable int id) throws Exception{
		return languagesService.getbyid(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguagesRequest createLanguagesRequest) throws Exception{
		languagesService.add(createLanguagesRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteLanguagesRequest deleteLanguagesRequest) throws Exception{
		languagesService.delete(deleteLanguagesRequest);
	}
	
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateLanguagesRequest updateLanguagesRequest) throws Exception{
		languagesService.update(updateLanguagesRequest);
	}
	
	
	
	
	
	
	
}
