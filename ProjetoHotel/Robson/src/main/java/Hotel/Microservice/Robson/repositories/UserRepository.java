package Hotel.Microservice.Robson.repositories;
import Hotel.Microservice.Robson.Model.User;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    /*JpaRepository,*/
    
}
