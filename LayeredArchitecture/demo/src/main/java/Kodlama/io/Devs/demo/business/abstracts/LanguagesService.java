package Kodlama.io.Devs.demo.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.demo.business.requests.languages.CreateLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.DeleteLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.languages.UpdateLanguagesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.DeleteTechnologiesRequest;
import Kodlama.io.Devs.demo.business.responses.languages.GetAllLanguagesResponse;
import Kodlama.io.Devs.demo.business.responses.languages.GetByIdLanguagesResponse;
import Kodlama.io.Devs.demo.entities.Languages;

public interface LanguagesService {
	public List<GetAllLanguagesResponse> getAll();
	public GetByIdLanguagesResponse getbyid(int id) throws Exception;
	public void add(CreateLanguagesRequest createLanguagesRequest) throws Exception;
	public void delete(DeleteLanguagesRequest deleteLanguagesRequest) throws Exception;
	public void update(UpdateLanguagesRequest updateLanguagesRequest) throws Exception;
	
}
