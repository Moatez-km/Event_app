package de.tekup.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.tekup.ex.services.ReactionsService;

@Controller
public class ReactionsController {

	@Autowired
	ReactionsService reactService;
	@PostMapping("/addReact")
	public String saveReactToDB(@RequestParam("idu") long id_user,@RequestParam("ida") long id_activite) {
		reactService.saveReact(id_user, id_activite);
		return "redirect:/main";
	}
}
