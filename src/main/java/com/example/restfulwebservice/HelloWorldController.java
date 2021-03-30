package com.example.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //https://github.com/edowon/restful-web-service.git
    // GET
    // /hello-world(endpoint)
    // @RequestMapping(method=RequestMethod.GET, path="hello-world")
    @GetMapping(path= "/hello-world")
    public String helloWorld(){
        return "Hello world";
    }

    //Bean형태 일때 RestController json으로 반
    @GetMapping(path= "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){  //option+enter bean 만들기 단축키
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path= "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable(value = "name") String name){  //option+enter bean 만들기 단축키
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}

