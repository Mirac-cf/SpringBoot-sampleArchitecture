package Kodlama.io.Devs.demo.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import Kodlama.io.Devs.demo.entities.Languages;


public interface LanguagesDal extends JpaRepository<Languages, Integer>{
	// JpaRepository<Languages, Integer> 
	// yukarda birinci arguman kullanacagımız entity (Languages)
	// ikinci arguman ise o entity'nin primery key turu (Integer)
	
	public Languages findById(int id);
}
