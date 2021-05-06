package de.tekup.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.tekup.ex.services.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	@PostMapping("/addMsg")
	public String AddMsg(@RequestParam("time")String time,@RequestParam("message")String message,@RequestParam("idu")long idu,@RequestParam("ida")long ida) {
		
		commentService.SaveComment(time,message, idu, ida);	
		
	return "redirect:/main";
	}
	
	
}
