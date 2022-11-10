package caro.Controller;

import caro.Model.User;
import caro.Repository.JdbcUserRepo;
import caro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/")
    public String showLoginForm(){
        return "login";
    }
//    @PostMapping("/")
//    public String login(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            Model model, HttpSession session){
//        String message = "";
//        if(userService.login(username,password)==null){
//            message = "Tên tài khoản hoặc mật khẩu không chính xác";
//            model.addAttribute("message",message);
//            System.out.println("message: "+message);
//            return "login";
//        };
//        User user = userService.login(username,password);
//        session.setAttribute("user",user);
//        return "main";
//    }
//    @PostMapping("/register")
//    public String register(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            Model model){
//        String message = "";
//        if(userService.register(username,password)==null){
//            message = "Tên tài khoản đã tồn tại";
//            model.addAttribute("message",message);
//        }
//        else {
//            userService.register(username,password);
//            message = "Đăng ký thành công";
//            model.addAttribute("message", message);
//            System.out.println(message);
//        }
//        return "login";
//    }
    @GetMapping("/main")
    public String Main(){
        return "main";
    }
    @GetMapping("/play")
    public String play(){
        return "play";
    }
    @GetMapping("/back")
    public String back(){
        return "redirect:/main";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("password");
        return "redirect:/login";
    }
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam("newname") String newname,
                       @RequestParam("newpass") String newpass,
                       Model model, HttpSession session){
        System.out.println("newname: "+newname);
        System.out.println("newpass: "+newpass);
        return "profile";
    }
}