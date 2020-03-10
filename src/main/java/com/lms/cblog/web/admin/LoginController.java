package com.lms.cblog.web.admin;

import com.lms.cblog.po.User;
import com.lms.cblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Autor Lms
 * Time 2019/9/1/001
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping         //不加映射路径的话，进入了/admin映射后，就自动进入这个映射的方法
//    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(){
        return "/admin/login";       //自动跳转到登录页面
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes, Model model){       //@RequestParam注解是用于接收前台post携带的参数/请求数据？
        User user =userService.checkUser(username,password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "/admin/wellcomePage";
        } else {
            attributes.addFlashAttribute("message","用户名和密码错误了");

            return "redirect:/admin";  //为什么这儿重定向的地址是mapping映射？
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("logout");
        return "redirect:/admin";
    }
}
