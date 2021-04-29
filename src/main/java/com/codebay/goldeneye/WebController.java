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
        //Checks if the department and the location matches with the valid options
        if(checkDepartment(employee.getDepartment(), employee.getLocation())) {
            employee.setEmail(employee.getName().toLowerCase(), employee.getSurname().toLowerCase(),
                    employee.getLocation().toLowerCase(), employee.getDepartment().toLowerCase());
        }
        model.addAttribute("employee", employee);
        return "index";
    }

    private boolean checkDepartment(String department, String location) {
        switch (location) {
            case "Milan":
                return department.equals("Design") || department.equals("Business") || department.equals("Advertising");
            case "Spain":
                return department.equals("Research & development") || department.equals("Business");
            case "New York":
                return department.equals("Business") || department.equals("Advertising");
        }

        return false;
    }
}