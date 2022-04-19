package com.springbootjsp.jspconfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class customerController {

    // @RequestMapping("/home")
    @GetMapping({"/","/home"})
    
    public String hello(@RequestParam(value="name",defaultValue = "world",required = false) String name,Model model)
    {
        model.addAttribute("name",name);
        return "home";
    }
    @ResponseBody
    @GetMapping({"/user","/shop"})
    public String user()
    {
        return "Welcome to Bikry";
    }
    @ResponseBody
    @GetMapping("/name")
    public String name()
    {
        return "Ankit kumar Sharma";
    }
    //Demo for Pathvariable and RequestParam
    //In casev if you have different mapping vriable name from the variable you are using in 
    @ResponseBody
    @GetMapping("/employee/{username}/{classname}")
    public String employee(@PathVariable("username") String name,@PathVariable("classname") String className)
    {
        return name+" "+className;
    }

    @ResponseBody
    @RequestMapping(value="/employee",method=RequestMethod.GET)
    // @GetMapping("/employee")
    public String employeeUser(@RequestParam("n") String name,@RequestParam("c") String className)
    {
        return name+" "+className;
    }
}
