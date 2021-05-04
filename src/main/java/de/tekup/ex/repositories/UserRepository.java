package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByEmailAndPassword(String email,String password);

}
