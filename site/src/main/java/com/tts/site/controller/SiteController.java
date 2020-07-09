package com.tts.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.site.model.Subscriber;
import com.tts.site.repository.SiteRepository;

@Controller
public class SiteController {
	
	@Autowired
	private SiteRepository subscriberRepository;

	@GetMapping
    public String index(Subscriber site) {
	return "JAG_website/index";
    }
	
//	@RequestMapping("/test")
//	public String test() {
//	    return "JAG_website/test";
//	}
	
	@RequestMapping("/Restaurants")
	public String Restaurants() {
	    return "JAG_website/Restaurants";
	}
	
	@RequestMapping("/aboutme")
	public String aboutme() {
	    return "JAG_website/aboutme";
	}	
	
	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber site, Model model) {
		subscriberRepository.save(new Subscriber(site.getFirstName(), 
	        site.getLastName(), site.getUsername(), site.getSignedUp(), site.getEmail()));
		model.addAttribute("firstName", site.getFirstName());
		model.addAttribute("lastName", site.getLastName());
		model.addAttribute("userName", site.getUsername());
		model.addAttribute("email", site.getEmail());
		return "JAG_website/result";
	}
}
