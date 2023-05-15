package com.foodwastage.backend.service;

import com.foodwastage.backend.model.Community;

// import java.util.Optional;

public interface CommunityService {
    public Community saveCommunity(Community community);
    public Community findByCode(String code);
}
