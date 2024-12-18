package com.wrox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    private GreetingService greetingService;

    @ResponseBody
    @RequestMapping("/")
    public String helloWorld()
    {
        return "Hello, World!";
    }

    @ResponseBody
    @RequestMapping(value = "/", params = {"name"})
    public String helloName(@RequestParam("name") String name)
    {
        return this.greetingService.getGreeting(name);
    }

    @Autowired
    public void setGreetingService(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }
}
