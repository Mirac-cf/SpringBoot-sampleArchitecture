package Kodlama.io.Devs.demo.business.requests.languages;

import java.util.List;

import Kodlama.io.Devs.demo.entities.Technologies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguagesRequest {
	private String name;
}
