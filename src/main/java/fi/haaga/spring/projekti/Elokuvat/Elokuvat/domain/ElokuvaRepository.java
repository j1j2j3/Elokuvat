package fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ElokuvaRepository extends CrudRepository<Elokuva, Long>{
	List<Elokuva> findById(long id);

}



