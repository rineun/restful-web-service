package com.example.restfulwebservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    private UserDaoService service;

    //생성자를 통해 의존성주입
    public AdminUserController(UserDaoService service){
        this.service = service;
    }
    @GetMapping("/users")   // "/admin/users"
    public MappingJacksonValue retrieveAllUsers(){
        //comman + 마우스 오른쪽 함수가기
        List<User> users = service.findAll();
        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","joinDate", "password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }

    //GET /users/1  -> String
    //GET  /v1/users/1
    // return 분리 블럭처리 마우스 오른쪽 introduce Variable
    @GetMapping("/v1/users/{id}") // "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV1(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));        }

    //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","password", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);


        return mapping;
    }

    @GetMapping("/v2/users/{id}") // "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV2(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));
        }
        UserV2 userV2 = new UserV2();
        //user객체를 userV2로 카
        BeanUtils.copyProperties(user, userV2); //id, name, joinDate, pasword, ssn
        userV2.setGrade("VIP");

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","joinDate", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);


        return mapping;
    }

    //Request parameter 버전관
    @GetMapping(value = "/users/{id}/", params = "version=1") // "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV1_1(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));        }

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","password", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);


        return mapping;
    }

    @GetMapping(value = "/users/{id}/", params = "version=2") // "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV2_1(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));
        }
        UserV2 userV2 = new UserV2();
        //user객체를 userV2로 카
        BeanUtils.copyProperties(user, userV2); //id, name, joinDate, pasword, ssn
        userV2.setGrade("VIP");

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","joinDate", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);


        return mapping;
    }

    //Header을 이용한 버전관리
    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1") // "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV1_2(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));        }

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","password", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);


        return mapping;
    }

    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2")// "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV2_2(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));
        }
        UserV2 userV2 = new UserV2();
        //user객체를 userV2로 카
        BeanUtils.copyProperties(user, userV2); //id, name, joinDate, pasword, ssn
        userV2.setGrade("VIP");

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","joinDate", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);


        return mapping;
    }


    //MineType 이용한 버전관리 Header Accept
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json") // "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV1_3(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));        }

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","password", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);


        return mapping;
    }

    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2+json")// "/admin/users/{id}"
    public MappingJacksonValue retrieveAllUserV2_3(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%S] not found", id));
        }
        UserV2 userV2 = new UserV2();
        //user객체를 userV2로 카
        BeanUtils.copyProperties(user, userV2); //id, name, joinDate, pasword, ssn
        userV2.setGrade("VIP");

        //포함시키고 싶은값을 넣음
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","joinDate", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);


        return mapping;
    }

}
