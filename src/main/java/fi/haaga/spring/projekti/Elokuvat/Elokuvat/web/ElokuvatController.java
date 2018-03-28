package fi.haaga.spring.projekti.Elokuvat.Elokuvat.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.Elokuva;
import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.ElokuvaRepository;
import fi.haaga.spring.projekti.Elokuvat.Elokuvat.domain.GenreRepository;
@Controller

public class ElokuvatController {
	
	@Autowired
	private ElokuvaRepository repository;
	
	@Autowired
	private GenreRepository grepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}  
	
	@RequestMapping(value="/elokuvalist", method=RequestMethod.GET)
	public String elokuvat(Model model) {
		model.addAttribute("elokuva", repository.findAll());
		return "elokuvalist";
	
	}
	
	@RequestMapping(value = "/add")
	public String addElokuva(Model model){
	model.addAttribute("elokuva", new Elokuva());
	model.addAttribute("genres", grepository.findAll());
	return "addelokuva";
	} 
	@RequestMapping(value="/addelokuva", method=RequestMethod.POST)
	public String addElokuva(Elokuva elokuva) {
		repository.save(elokuva);
		return "redirect:/elokuvalist";
	}
	
	@RequestMapping(value = "/editelokuva/{id}", method = RequestMethod.GET)
	public String editElokuva(@PathVariable("id") Long elokuvaId, Model model) {
		model.addAttribute("elokuva", repository.findById(elokuvaId));
		model.addAttribute("genres", grepository.findAll());
	return "editelokuva";
	}
	
	@RequestMapping(value="/editelokuva/editelokuva", method=RequestMethod.POST)
	public String editElokuva(Elokuva elokuva) {
		repository.save(elokuva);
		return "redirect:/elokuvalist";
	}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteElokuva(@PathVariable("id") Long elokuvaId, Model model) {
	repository.deleteById(elokuvaId);
	return "redirect:/elokuvalist";
	}
	
	// RESTful service to get all movies
    @RequestMapping(value="/elokuvat", method = RequestMethod.GET)
    public @ResponseBody List<Elokuva> elokuvaListRest() {	
        return (List<Elokuva>) repository.findAll();
    }    

	// RESTful service to get movie by id
    @RequestMapping(value="/elokuvat/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Elokuva> findElokuvaRest(@PathVariable("id") Long elokuvaId) {	
    	return repository.findById(elokuvaId);
    }   
    
    
	
}


