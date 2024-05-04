//package com.assignment.testproject.user;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/main")
//public class MainController {
//    private final UserService userService;
//
//    public MainController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/index")
//    public String showHomePage() {
//        return "index";
//    }
//
//    @GetMapping("/test")
//    public String showRegister(Model model) {
//        model.addAttribute("user", new User());
//        return "testPage";
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String submitRegisterForm(@ModelAttribute("user") User user){
//        userService.createUser(user);
//        return "redirect:/register?success"; // Redirect to the register page with a success parameter
//    }
//
//    @GetMapping("/registration-success")
//    public String registrationSuccess() {
//        return "registration-success";
//    }
//
//
//}
