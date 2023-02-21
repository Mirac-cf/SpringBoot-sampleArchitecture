package Kodlama.io.Devs.demo.business.responses.languages;

import java.util.List;

import Kodlama.io.Devs.demo.entities.Technologies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguagesResponse {
	private String name;
	private List<Technologies> languageTechnologies;
}
