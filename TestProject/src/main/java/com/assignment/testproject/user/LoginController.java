//package com.assignment.testproject.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class LoginController {
//
//    private final UserService userService;
//
//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("loginForm", new LoginForm());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String submitLoginForm(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
//        if (!userService.authenticateUser(loginForm.getUsername(), loginForm.getPassword())) {
//            model.addAttribute("error", true);
//            return "redirect:/login?error";
//        } else {
//            return "redirect:/success";
//        }
//    }
//
//
//}
