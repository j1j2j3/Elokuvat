package fi.haaga.spring.projekti.Elokuvat.Elokuvat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.Elokuva;
import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.ElokuvaRepository;
import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.Genre;
import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.GenreRepository;



@SpringBootApplication
public class ElokuvatApplication {
	private static final Logger log = LoggerFactory.getLogger(ElokuvatApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ElokuvatApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(ElokuvaRepository repository, GenreRepository grepository){
		return args -> {
			log.info("tallenna muutama elokuva");
			grepository.save(new Genre("Toiminta"));
			grepository.save(new Genre("Tiede"));
			grepository.save(new Genre("Seikkailu"));
			//id, nimi, julkaisuvuosi, ohjaaja, kesto, (genre)
			repository.save(new Elokuva(1, "Iron Man 3", 2013, "Shane Black", 130, grepository.findByName("Toiminta").get(0)));
			repository.save(new Elokuva(2, "The Avengers", 2012, "Joss Whedon", 143, grepository.findByName("Toiminta").get(0)));
			
			log.info("hae kaikki elokuvat");
			for (Elokuva elokuva : repository.findAll()) {
				log.info(elokuva.toString());
			}
		};
	}
	
	}
		

