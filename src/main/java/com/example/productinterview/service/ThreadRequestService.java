package com.example.productinterview.service;

import com.example.productinterview.Model.ThreadChangeRequest;
import com.example.productinterview.Repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadRequestService {

    @Autowired
    ThreadRepository threadRepository;

    public void saveThreadRequest(ThreadChangeRequest request) {
        threadRepository.save(request);
    }
}
