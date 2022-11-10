package caro.api;

import caro.Model.User;
import caro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserAPI {
    private UserService userService;
    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        if(userService.login(username,password)==null)
        return new ResponseEntity<>("Tên tài khoản hoặc mật khẩu không chính xác", HttpStatus.BAD_REQUEST);
        User user = userService.login(username,password);
        session.setAttribute("user",user);
        return new ResponseEntity<>("Đăng nhập thành công",HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam("username")String username,@RequestParam("password") String password){
        if(userService.register(username,password)==null){
            return new ResponseEntity<>("Tên tài khoản đã tồn tại",HttpStatus.BAD_REQUEST);
        }
        User user = userService.register(username,password);
        return new ResponseEntity<>("Đăng ký thành công",HttpStatus.OK);
    }
//    @PutMapping("/update")
//    public User readUser(@RequestParam("id") String id,@RequestBody User user){
//        System.out.println(id);
//        return user;
//    }
//    @GetMapping("/user")
//    public User updateUser(@RequestBody User user){
//        return user;
//    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id")String id){
//        return id;
//    }
}
