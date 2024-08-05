package Hotel.Microservice.Robson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Hotel.Microservice.Robson.Model.User;
import Hotel.Microservice.Robson.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuario " + id + " nao encontrado " + User.class.getName()));

    }

    @Transactional
    public User create(User obj){
        obj=this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj=findById(obj.getId());
        newObj.setAdress(obj.getAdress());
        newObj.setBirthday(obj.getBirthday());
        newObj.setContact(obj.getContact());
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        }catch(Exception e){
            //Todo handle exception
            throw new RuntimeException("Nao e possivel deletar o usuario pois e necesario no banco de dados");

        }
    }
    
    
}
