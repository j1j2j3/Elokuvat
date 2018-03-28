package fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long genreid;
	private String name;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "genre")
	
	private List<Elokuva> elokuvat;
	
	public Genre() {	
		
	}

	public Genre(String name) {
		super();
		
		this.name = name;
		
	}

	public long getGenreid() {
		return genreid;
	}

	public void setGenreid(long genreid) {
		this.genreid = genreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Elokuva> getElokuvat() {
		return elokuvat;
	}

	public void setElokuvat(List<Elokuva> elokuvat) {
		this.elokuvat = elokuvat;
	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", name=" + name+ "]";
	}
	
	
}
