package com.codebay.goldeneye;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

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
            String name = StringUtils.stripAccents(employee.getName().toLowerCase());
            String surname = StringUtils.stripAccents(employee.getSurname().toLowerCase());
            String location = (employee.getLocation().equals("New York")) ? "newyork" : employee.getLocation().toLowerCase();
            String department = (employee.getDepartment().equals("Research & development")) ? "research&development" : employee.getDepartment().toLowerCase();

            employee.setEmail(name, surname, location, department);
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