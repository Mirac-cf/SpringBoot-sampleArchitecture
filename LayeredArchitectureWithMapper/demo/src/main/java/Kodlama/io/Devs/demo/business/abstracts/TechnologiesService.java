package Kodlama.io.Devs.demo.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.demo.business.requests.technologies.CreateTechnologiesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.DeleteTechnologiesRequest;
import Kodlama.io.Devs.demo.business.requests.technologies.UpdateTechnologiesRequest;
import Kodlama.io.Devs.demo.business.responses.technologies.GetAllTechnologiesResponse;
import Kodlama.io.Devs.demo.business.responses.technologies.GetByIdTechnologiesResponse;

public interface TechnologiesService {
	public List<GetAllTechnologiesResponse> getAll();
	public GetByIdTechnologiesResponse findById(int id) throws Exception;
	public void add(CreateTechnologiesRequest createTechnologiesRequest) throws Exception;
	public void delete(DeleteTechnologiesRequest deleteTechnologiesResponse) throws Exception;
	public void update(UpdateTechnologiesRequest updateTechnologiesRequest) throws Exception;
}
