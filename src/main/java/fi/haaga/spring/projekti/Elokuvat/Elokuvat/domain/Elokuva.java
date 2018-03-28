package fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Elokuva {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String nimi;
private int julkaisuvuosi;
private String  ohjaaja;
private int kesto;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "genreid")
private Genre genre;

public Elokuva(){}

public Elokuva(long id, String nimi, int julkaisuvuosi, String ohjaaja,
		int kesto, Genre genre) {
	super();
	this.id = id;
	this.nimi = nimi;
	this.julkaisuvuosi = julkaisuvuosi;
	this.ohjaaja = ohjaaja;
	this.kesto = kesto;
	this.genre = genre;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNimi() {
	return nimi;
}
public void setNimi(String nimi) {
	this.nimi = nimi;
}
public int getJulkaisuvuosi() {
	return julkaisuvuosi;
}
public void setJulkaisuvuosi(int julkaisuvuosi) {
	this.julkaisuvuosi = julkaisuvuosi;
}
public String getOhjaaja() {
	return ohjaaja;
}
public void setOhjaaja(String ohjaaja) {
	this.ohjaaja = ohjaaja;
}
public int getKesto() {
	return kesto;
}
public void setKesto(int kesto) {
	this.kesto = kesto;
}
	public Genre getGenre(){
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
@Override
public String toString() {
	if (this.genre!= null)
	return "Elokuva [id=" + id + ", nimi=" + nimi + ", julkaisuvuosi="+ julkaisuvuosi + ", ohjaaja=" + ohjaaja + ", kesto=" + kesto + " genre=" + this.getGenre()+ "]";
	else
		return "Elokuva [id=" + id + ", nimi=" + nimi + ", julkaisuvuosi="+ julkaisuvuosi + ", ohjaaja=" + ohjaaja + ", kesto=" + kesto + "]";
	}

}

