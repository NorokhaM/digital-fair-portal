package com.hacknimeto.fair_service.services;

import com.hacknimeto.fair_service.entities.Fair;
import com.hacknimeto.fair_service.entities.UserEntity;
import com.hacknimeto.fair_service.repositories.FairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FairService {

    private final FairRepository fairRepository;
    private final UserClient userClient;

    @Autowired
    public FairService(FairRepository fairRepository, UserClient userClient) {
        this.fairRepository = fairRepository;
        this.userClient = userClient;
    }

    public Fair save(Fair fair, Long userId) {
        UserEntity user = userClient.getUserById(userId);
        fair.setUser(user);
        fair.setUserId(user.getId());
        return fairRepository.save(fair);
    }

    public Fair findById(Long id) {
        return fairRepository.findById(id).orElse(null);
    }

    public List<Fair> findAll() {
        return fairRepository.findAll();
    }

    public void deleteById(Long id) {
        fairRepository.deleteById(id);
    }


}
