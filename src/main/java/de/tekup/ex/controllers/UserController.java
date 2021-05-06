package de.tekup.ex.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import de.tekup.ex.models.Activite;
import de.tekup.ex.models.Comment;
import de.tekup.ex.models.User;
import de.tekup.ex.repositories.ActivityRepository;
import de.tekup.ex.repositories.CommentRepository;
import de.tekup.ex.repositories.UserRepository;
import de.tekup.ex.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService UserService;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ActivityRepository activityRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	@GetMapping("/addNewUser")
	public String showAddUser() {
		return "/addUser.html";
		
	}

	
	
	@GetMapping("/login")
	public String showlogPage() {
		return "/login.html";
		
	}
	@PostMapping("/adduser")
	public String AdduserToDb(@RequestParam("file") MultipartFile file,@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email,@RequestParam("password") String password) {
		
		UserService.saveUser(file, nom, prenom, email, password);
		return "redirect:/login";
	}
	
	@PostMapping("/login")
	public String userbyemail(@RequestParam("email") String email, @RequestParam("password")String password,HttpSession session,Model model) {
		
		User user=UserService.getUserByEmailAndPassword(email, password);
		if(user!=null) {
			session.setAttribute("nom", user.getNom());
			session.setAttribute("id", user.getId());
			session.setAttribute("prenom",user.getPrenom());
			session.setAttribute("image",user.getImage());
			model.addAttribute("users", user);
			return "redirect:/main";
			
		}
		
		return "redirect:/login";
	}

	@GetMapping("/main")
	public String showUsers(Model model,String keyword) {
		if(keyword!=null) {
			model.addAttribute("users", UserService.findByKeyword(keyword));
		}else {
			model.addAttribute("users", UserService.getAllUsers());
		}
		List<Activite>activties=activityRepo.findAll();
		model.addAttribute("activities", activties);
		
		List<Comment>comments=commentRepo.findAll();
		model.addAttribute("comments", comments);
		return "/main.html";
		
		
	}
	
	/*@GetMapping("/users")
	public String viewHomePage(Model model,String keyword) {
		if(keyword!=null) {
			model.addAttribute("users", UserService.findByKeyword(keyword));
		}else {
			model.addAttribute("users", UserService.getAllUsers());
		}
		return "/main";
		
		
		
		
	}*/
}
