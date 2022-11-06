package com.leeyunjin.hello.umcspring.info;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class InfoController {

    @GetMapping("/info")
    public String projefctInfo(){
        return "Project name is umcspring";
    }
}

