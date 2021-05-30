package kodlamaio.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	// find yada get hansini secirsense butun proyektde o olmalidi
	User findByEmail(String email);
}
