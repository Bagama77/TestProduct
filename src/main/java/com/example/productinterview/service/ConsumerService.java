package com.example.productinterview.service;

import com.example.productinterview.Model.ConsumerCounter;
import com.example.productinterview.Model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class ConsumerService {
    public void getConsumers(int quantity){
        IntStream.range(0, quantity).forEach(ord -> new ConsumerCounter().run());
    }
}
