package Kodlama.io.Devs.demo.business.concrete;

import java.util.List;

import org.springframework.stereotype.Service;
import Kodlama.io.Devs.demo.business.abstracts.LanguagesService;
import Kodlama.io.Devs.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.DeleteLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.Devs.demo.business.responses.languages.GetAllLanguagesResponse;
import Kodlama.io.Devs.demo.business.responses.languages.GetByIdLanguagesResponse;
import Kodlama.io.Devs.demo.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.demo.dataAccess.abstracts.LanguagesDal;
import Kodlama.io.Devs.demo.entities.Languages;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguagesManager implements LanguagesService{
	
	private LanguagesDal languagesDal;
	private ModelMapperService modelMapperService;
	

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Languages> languages = languagesDal.findAll();
		List<GetAllLanguagesResponse> response = languages.stream().
				map(language -> modelMapperService.forResponse().map(language, GetAllLanguagesResponse.class)).toList();
		
		return response;
	}
	
	
	@Override
	public void add(CreateLanguagesRequest createLanguagesRequest) throws Exception{
		checkNameValid(createLanguagesRequest.getName()); 
		Languages languages = modelMapperService.forRequest().map(createLanguagesRequest, Languages.class);
		languagesDal.save(languages);
	}
	
	@Override
	public GetByIdLanguagesResponse getbyid(int id) throws Exception {
		checkIdValid(id);
		
		Languages languages = languagesDal.findById(id);
		GetByIdLanguagesResponse getByIdLanguagesResponse = modelMapperService.forResponse().map(languages, GetByIdLanguagesResponse.class);
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
		
		Languages languages = modelMapperService.forRequest().map(updateLanguagesRequest, Languages.class);
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
