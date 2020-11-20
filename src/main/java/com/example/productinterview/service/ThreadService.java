package com.example.productinterview.service;

import com.example.productinterview.Model.ConsumerCounter;
import com.example.productinterview.Model.ProducerCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ThreadService {
    @Autowired
    ConsumerCounter consumerCounter;

    @Autowired
    ProducerCounter producerCounter;

    public void executeCounterChange(int consumerChange, int producerChange){
        List<Thread> totalList = getProducers(producerChange);
        totalList.addAll(getConsumers(consumerChange));
        totalList.parallelStream().forEach(thread -> thread.start());
    }

    public List<Thread> getConsumers(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(count ->{ return new Thread(consumerCounter);})
                .collect(Collectors.toList());
    }

    public List<Thread> getProducers(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(count ->{return new Thread(producerCounter);})
                .collect(Collectors.toList());
    }
}
