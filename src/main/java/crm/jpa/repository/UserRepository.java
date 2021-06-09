package crm.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crm.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByMail(String mail);
	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
}
