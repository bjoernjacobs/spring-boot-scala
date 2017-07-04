package de.codecentric.microservice.controller;

import de.codecentric.microservice.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyServiceJavaController {

    private final MyService myService;

    @Autowired
    public MyServiceJavaController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(path = "/testjava", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String handleRequest() {
        return "Hallo from a Java controller! " + myService.getMessage();
    }
}
