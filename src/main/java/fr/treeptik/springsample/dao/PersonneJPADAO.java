package fr.treeptik.springsample.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import fr.treeptik.springsample.model.Personne;

@Repository // steréotype de component pour les beans de type DAO
@Profile("jpa") // bean instancié si le profile jpa est actif
public class PersonneJPADAO implements PersonneDAO {

	@Override
	public Personne save(Personne personne) {
		System.out.println("methode JPA");
		return null;
	}

}
