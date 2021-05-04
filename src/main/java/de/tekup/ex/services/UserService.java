package de.tekup.ex.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import de.tekup.ex.models.User;



public interface UserService {
	List<User> getAllUsers();
	void saveUser(MultipartFile file, String nom,String prenom,String email,String password);
	User getUserById(Long id);
	void deleteUserById(Long id);
	User getUserByEmailAndPassword(String email,String password);
	

}
