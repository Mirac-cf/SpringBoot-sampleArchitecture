package Kodlama.io.Devs.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "programinglanguage")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Languages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //id otomatik artsın
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy = "programingLanguage",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Technologies> languageTechnologies;
	
	// mappedBy kullanılırsa database de bu ilişki için yeni bir tablo oluşmaz fakat entity içindi bu ilişkiler var olmaya devam eder 
	
}
