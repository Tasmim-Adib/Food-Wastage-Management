package com.foodwastage.backend.controller;

import com.foodwastage.backend.model.Community;
import com.foodwastage.backend.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @PostMapping("/community/add")
    public String add(@RequestBody Community community){
        communityService.saveCommunity(community);
        return "new Community Saved";
    }

    @GetMapping("/community/{code}")
    public Community getCommunity(@PathVariable String code){
        return communityService.findByCode(code);
    }
}
