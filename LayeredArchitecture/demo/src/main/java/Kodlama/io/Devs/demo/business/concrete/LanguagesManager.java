package Kodlama.io.Devs.demo.business.concrete;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import Kodlama.io.Devs.demo.business.abstracts.LanguagesService;
import Kodlama.io.Devs.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.DeleteLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.DeleteTechnologiesRequest;
import Kodlama.io.Devs.demo.business.responses.languages.GetAllLanguagesResponse;
import Kodlama.io.Devs.demo.business.responses.languages.GetByIdLanguagesResponse;
import Kodlama.io.Devs.demo.business.responses.technologies.GetByIdTechnologiesResponse;
import Kodlama.io.Devs.demo.dataAccess.abstracts.TechnologiesDal;
import Kodlama.io.Devs.demo.dataAccess.abstracts.LanguagesDal;
import Kodlama.io.Devs.demo.entities.Languages;
import Kodlama.io.Devs.demo.entities.Technologies;

@Service
public class LanguagesManager implements LanguagesService{
	
	private LanguagesDal languagesDal;
	
	
	public LanguagesManager(LanguagesDal languagesDal) {
		this.languagesDal = languagesDal;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Languages> languages = languagesDal.findAll();
		List<GetAllLanguagesResponse> getAllLanguagesResponses = new ArrayList<GetAllLanguagesResponse>();
		
		for (Languages language : languages) {
			GetAllLanguagesResponse result = new GetAllLanguagesResponse();
			result.setId(language.getId());
			result.setName(language.getName());
			result.setLanguageTechnologies(language.getLanguageTechnologies());
			getAllLanguagesResponses.add(result);
		}
		return getAllLanguagesResponses;
	}
	
	
	@Override
	public void add(CreateLanguagesRequest createLanguagesRequest) throws Exception{
		checkNameValid(createLanguagesRequest.getName()); 
		Languages languages = new Languages();
		languages.setName(createLanguagesRequest.getName());
		languagesDal.save(languages);
	}
	
	@Override
	public GetByIdLanguagesResponse getbyid(int id) throws Exception {
		checkIdValid(id);
		
		GetByIdLanguagesResponse getByIdLanguagesResponse = new GetByIdLanguagesResponse();
		Languages languages = languagesDal.findById(id);
		getByIdLanguagesResponse.setName(languages.getName());
		getByIdLanguagesResponse.setLanguageTechnologies(languages.getLanguageTechnologies());
		return getByIdLanguagesResponse;
	}
	
	@Override
	public void delete(DeleteLanguagesRequest deleteLanguagesRequest) throws Exception {
		checkIdValid(deleteLanguagesRequest.getId());
		Languages languages = languagesDal.findById(deleteLanguagesRequest.getId());
		languagesDal.delete(languages);
	}
	
	
	@Override
	public void update(UpdateLanguagesRequest updateLanguagesRequest) throws Exception{
		checkNameValid(updateLanguagesRequest.getName());
		checkIdValid(updateLanguagesRequest.getId());
		
		Languages languages = new Languages();
		languages.setId(updateLanguagesRequest.getId());
		languages.setName(updateLanguagesRequest.getName());
		languagesDal.save(languages);
		
	}
	
	
	
	public void checkNameValid(String name) throws Exception {
		if(name.isBlank()) throw new Exception("Name can't be null...!");
		
		for (Languages lessons : languagesDal.findAll()) {
			if(name.equalsIgnoreCase(lessons.getName()))  throw new Exception("This name already exist...!");
		}
	}
	
	
	
	public void checkIdValid(int id) throws Exception{
		boolean control = false;

		List<Languages> languages = languagesDal.findAll();
		for (Languages language : languages) {
			if (language.getId() == id) {
				control = true;
				break;
			}
		}
		
		if(!control) throw new Exception("Id is not found!");
	}
	
}
