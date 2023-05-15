package com.foodwastage.backend.service;

import com.foodwastage.backend.model.Community;
import com.foodwastage.backend.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    public CommunityRepository communityRepository;
    @Override
    public Community saveCommunity(Community community) {
        return communityRepository.save(community);
    }

    @Override
    public Community findByCode(String code) {
        Optional<Community> community = communityRepository.findByCode(code);
        if(community.isPresent()){
            return community.get();
        }
        throw new RuntimeException("Community not found in " + code);
    }
}
