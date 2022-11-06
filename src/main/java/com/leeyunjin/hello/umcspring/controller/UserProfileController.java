package com.leeyunjin.hello.umcspring.controller;


import com.leeyunjin.hello.umcspring.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "이윤진", "1238-4567", "서울시 서대문구 아현동"));
        userMap.put("2", new UserProfile("2", "김윤진", "1257-5892", "서울시 서대문구 대현동"));
        userMap.put("3", new UserProfile("3", "박윤진", "7829-1783", "서울시 서대문구 신촌동"));
    }

    //GetMapping 일반적으 데이터 조회로
    //Post 데이터 수정
    //Put 데이터 생성
    //Delete 데이터 삭제
    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<UserProfile>(userMap.values());
    }

    //RequestParam 으로 인자 전달 받는다
    @PutMapping("user/{id}")
    public void putUserProfile(
            @PathVariable("id") String id,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address) {
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);
    }

    //수정
    @PostMapping("user/{id}")
    public void postUserProfile(
            @PathVariable("id") String id,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address) {
        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    //삭제
    @DeleteMapping("user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        userMap.remove(id);
    }
}