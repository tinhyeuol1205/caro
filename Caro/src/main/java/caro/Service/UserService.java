package caro.Service;

import caro.Model.User;
import caro.Repository.JdbcUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private JdbcUserRepo jdbcUserRepo;
    public User login(String username, String password){
        if(jdbcUserRepo.findByUsername(username)!=null) {
            User user = jdbcUserRepo.findByUsername(username);
            if (user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }
    public User getUser(String username){
        User user = jdbcUserRepo.findByUsername(username);
        return user;
    }
    public User register(String username,String password){
        if(jdbcUserRepo.isUsernameExist(username)) return null;
        return jdbcUserRepo.save(username,password);
    }
}
