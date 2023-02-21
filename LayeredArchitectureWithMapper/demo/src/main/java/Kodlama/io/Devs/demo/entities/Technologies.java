package Kodlama.io.Devs.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "language_technologies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Technologies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	@JsonIgnore  // json formatında programların teklonojileri olarak gözükmesini sağlıyor
	@ManyToOne
	@JoinColumn(name = "language_id",nullable = false) 
	private Languages programingLanguage;

	// @JoinColumn ile hangi tablonun hangi sutünu ile bağlantılı olduğu belirtilir 
	//cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false
}
