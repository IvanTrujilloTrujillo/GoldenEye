package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {  
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String showEmail(Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "index";
    }
}