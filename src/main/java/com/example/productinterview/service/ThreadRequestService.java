package com.example.productinterview.service;

import com.example.productinterview.Model.ThreadChangeRequest;
import com.example.productinterview.Repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ThreadRequestService {

    @Autowired
    ThreadRepository threadRepository;

    public void saveThreadRequest(int increaseConsumer, int increaseProducer) {
        ThreadChangeRequest request = new ThreadChangeRequest();
        request.setIncreaseProducers(increaseProducer);
        request.setIncreaseConsumers(increaseConsumer);
        request.setCreated(LocalDateTime.now());
        threadRepository.save(request);
    }
}
