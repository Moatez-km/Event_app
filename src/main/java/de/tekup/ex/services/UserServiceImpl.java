package de.tekup.ex.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import de.tekup.ex.models.User;
import de.tekup.ex.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	
@Autowired
	private UserRepository userRepo;
	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	

	@Override
	public User getUserById(Long id) {

		Optional<User> optional=userRepo.findById(id);
		User user =null;
		if(optional.isPresent()) {
			user=optional.get();
			
			
		}else {
			throw new RuntimeException("User not found for id ::"+id);
		}
		
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		
	
		this.userRepo.deleteById(id);
		
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		
		return userRepo.findUserByEmailAndPassword(email, password);
	}

	@Override
	public void saveUser(MultipartFile file, String nom, String prenom, String email, String password) {
		// TODO Auto-generated method stub
		User u=new User();
		String fileName=org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			throw new NoSuchElementException("image not valid");
			}
		try {
			u.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setEmail(email);
		u.setPassword(password);
		userRepo.save(u);
		
	}
	
	

}
