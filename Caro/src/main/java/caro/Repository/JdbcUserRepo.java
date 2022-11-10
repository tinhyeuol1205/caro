package caro.Repository;

import caro.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JdbcUserRepo{
    private JdbcTemplate jdbc;
    private ConcurrentHashMap<String,User> users = new ConcurrentHashMap<>();

    @Autowired
    public JdbcUserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
        List<Map<String,Object>> rows =  jdbc.queryForList("Select * FROM user");
        for(Map row: rows){
            User user = new User();
            user.setId((String)row.get("id"));
            user.setUsername((String)row.get("username"));
            user.setPassword((String) row.get("password"));
            user.setWin((int) row.get("win"));
            user.setLose((int) row.get("lose"));
            users.put(user.getId(),user);
        }
    }

    public User save(String username,String password) {
        String id = UUID.randomUUID().toString();
        User user = new User(id,username,password,0,0);
        users.put(id,user);
        jdbc.update("insert into user (id,username,password,win,lose) values (?,?,?,?,?)",
                id,user.getUsername(),user.getPassword(),user.getWin(),user.getLose());
        return user;
    }

    public boolean isUsernameExist(String username){
        return users.values().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username)).count()>0;
    }

    public User findByUsername(String username){
        for(User user:users.values()){
            if(user.getUsername().equals(username)) return user;
        }
        return null;
    }
}
