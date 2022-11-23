package Kodlama.io.Devs.demo.business.requests.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTechnologiesRequest {
	private String name;
	private int languageId;
}
