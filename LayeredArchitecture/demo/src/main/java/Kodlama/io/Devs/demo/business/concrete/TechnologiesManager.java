package Kodlama.io.Devs.demo.business.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.demo.business.abstracts.TechnologiesService;
import Kodlama.io.Devs.demo.business.requests.technologies.CreateTechnologiesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.DeleteTechnologiesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.UpdateTechnologiesRequest;
import Kodlama.io.Devs.demo.business.responses.technologies.GetAllTechnologiesResponse;
import Kodlama.io.Devs.demo.business.responses.technologies.GetByIdTechnologiesResponse;
import Kodlama.io.Devs.demo.dataAccess.abstracts.LanguagesDal;
import Kodlama.io.Devs.demo.dataAccess.abstracts.TechnologiesDal;
import Kodlama.io.Devs.demo.entities.Languages;
import Kodlama.io.Devs.demo.entities.Technologies;

@Service
public class TechnologiesManager implements TechnologiesService{
	
	private TechnologiesDal technologieDal;
	private LanguagesDal languagesDal;
	
	public TechnologiesManager(TechnologiesDal technologieDal,LanguagesDal languagesDal) {
		this.technologieDal = technologieDal;
		this.languagesDal = languagesDal;
	}


	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technologies> technologies = technologieDal.findAll();
		List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<GetAllTechnologiesResponse>();
		
		for(Technologies tech : technologies) {
			GetAllTechnologiesResponse getAllTechnologiesResponse = new GetAllTechnologiesResponse();
			getAllTechnologiesResponse.setId(tech.getId());
			getAllTechnologiesResponse.setName(tech.getName());
			getAllTechnologiesResponse.setLanguageId(tech.getProgramingLanguage().getId());
			//getAllTechnologiesResponse.setLanguageName(tech.getProgramingLanguage().getName());
			technologiesResponses.add(getAllTechnologiesResponse);
		}
		
		return technologiesResponses;
	}


	@Override
	public void add(CreateTechnologiesRequest createTechnologiesRequest) throws Exception{
		checkNameValid(createTechnologiesRequest.getName());
		Languages languages = languagesDal.findById(createTechnologiesRequest.getLanguageId());
		Technologies technologies = new Technologies();
		technologies.setName(createTechnologiesRequest.getName());
		technologies.setProgramingLanguage(languages);
		technologieDal.save(technologies);
		
	}


	@Override
	public void delete(DeleteTechnologiesRequest deleteTechnologiesResponse) throws Exception{
		checkIdValid(deleteTechnologiesResponse.getId());
		Technologies technologies = technologieDal.findById(deleteTechnologiesResponse.getId());
		technologieDal.delete(technologies);
	}


	@Override
	public void update(UpdateTechnologiesRequest updateTechnologiesRequest) throws Exception{
		checkNameValid(updateTechnologiesRequest.getName());
		checkIdValid(updateTechnologiesRequest.getId());
		
		Technologies technologies = new Technologies();
		Languages languages = languagesDal.findById(updateTechnologiesRequest.getLanguageId());
		
		technologies.setId(updateTechnologiesRequest.getId());
		technologies.setName(updateTechnologiesRequest.getName());
		technologies.setProgramingLanguage(languages);
		technologieDal.save(technologies);
			
	}

	
	@Override
	public GetByIdTechnologiesResponse findById(int id) throws Exception {
		checkIdValid(id);
		
		GetByIdTechnologiesResponse getByIdTechnologiesResponse = new GetByIdTechnologiesResponse();
		Technologies technologies = technologieDal.findById(id);
		getByIdTechnologiesResponse.setName(technologies.getName());	
		return getByIdTechnologiesResponse;
	}
	
	
	public void checkNameValid(String name) throws Exception{
		
		if(name.isBlank()) throw new Exception("Name can't be null...!");
		
		for(Technologies technologies : technologieDal.findAll()) {
			if(name.equalsIgnoreCase(technologies.getName())) throw new Exception("This name already exist...!");
		}
	}
	
	
	public void checkIdValid(int id) throws Exception{
		boolean control = false;
		
		List<Technologies> technologies = technologieDal.findAll();
		for (Technologies technologi : technologies) {
			if(technologi.getId() == id) {
				control = true;
				break;
			}
		}
		
		if(!control) throw new Exception("Id is not found!");
	}

	
	
}



