package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String getHello() {
        return "get Hello";
    }

    // get / post / put / delete
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get http://localhost:9090/api/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    //TODO queryParam
    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam(
                      @RequestParam String name,
                      @RequestParam String email,
                      @RequestParam int age
                      ) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name +" " + email + " " + age;
    }

    // 추천 방법
    // ?user=steve&email=steve@gmail.com&age=29&address=서울시
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getNamne());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
