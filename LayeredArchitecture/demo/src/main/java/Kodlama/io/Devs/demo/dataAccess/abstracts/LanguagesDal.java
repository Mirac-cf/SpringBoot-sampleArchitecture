package Kodlama.io.Devs.demo.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import Kodlama.io.Devs.demo.entities.Languages;


public interface LanguagesDal extends JpaRepository<Languages, Integer>{
	Languages findById(int id);
}
