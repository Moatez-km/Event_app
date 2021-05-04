package de.tekup.ex.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import de.tekup.ex.services.ActivityService;

@Controller
public class ActiviteController {
	
	@Autowired
	private ActivityService activityService;
	
	
	@GetMapping("/log")
	public String showLogin2Page() {
		return "/login.html";
		
	}
	@GetMapping("/addact")
	public String showAddact() {
		return "/addActivity.html";
		
	}
	
	@PostMapping("/addActivity")
	public String SaveAct(@RequestParam("file") MultipartFile file,@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("type") String type,@RequestParam("idu") long idu,@RequestParam("date")String date) {
		activityService.SaveActivityToDB(file, name, description, type,date, idu);
		return "redirect:/main";
	}
	
/*
	@GetMapping("/listAct")
	public String showActivitys(Model model) {
		List<Activite>activties=activityRepo.findAll();
		model.addAttribute("activities", activties);
		return"/main.html";
	}*/
}
