package Kodlama.io.Devs.demo.business.requests.languages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguagesRequest {
	private int id;
	private String name;
	
}
