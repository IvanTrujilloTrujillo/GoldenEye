package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
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

        //API to control the undesired characters
        //cleanUndesiredCharacters(employee);

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

    private void cleanUndesiredCharacters(Employee employee) {
        String uri = "http://urlName/";

        RestTemplate restTemplate = new RestTemplate();
        employee.setName(restTemplate.getForObject(uri + employee.getName(), String.class));
        employee.setSurname(restTemplate.getForObject(uri + employee.getSurname(), String.class));
        employee.setLocation(restTemplate.getForObject(uri + employee.getLocation(), String.class));
        employee.setDepartment(restTemplate.getForObject(uri + employee.getDepartment(), String.class));
    }
}