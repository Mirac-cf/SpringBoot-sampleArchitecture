package Kodlama.io.Devs.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.demo.entities.Technologies;

public interface TechnologiesDal extends JpaRepository<Technologies, Integer>{
	public Technologies findById(int id);
}
