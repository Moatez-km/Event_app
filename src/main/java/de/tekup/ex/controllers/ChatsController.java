package de.tekup.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import de.tekup.ex.models.Chats;
import de.tekup.ex.repositories.ChatsRepository;
import de.tekup.ex.services.ChatsService;
import de.tekup.ex.services.UserService;


@Controller
public class ChatsController {
	
	@Autowired
	private ChatsService chatservice;
	@Autowired
	private UserService UserService;
	@Autowired
	private ChatsRepository chatRepo;

	@GetMapping("/chatBox")
	public String showNewChat(Model model,String keyword) {
		if(keyword!=null) {
			model.addAttribute("users", UserService.findByKeyword(keyword));
		}else {
			model.addAttribute("users", UserService.getAllUsers());
		}
		
		java.util.List<Chats>chats=chatRepo.findAll();
		model.addAttribute("chats", chats);
		
		return "/chatBox.html";
		
	}

	@PostMapping("/addChat")
	public String AddNewChats(@RequestParam("message")String message,@RequestParam("date")String date,@RequestParam("idU")long id_user) {
		
		chatservice.SaveChats(message, date, id_user);
		
		
		return "redirect:/chatBox";
	}
}
