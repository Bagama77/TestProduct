package com.example.productinterview.service;

import com.example.productinterview.Model.Counter;
import com.example.productinterview.Model.CounterEntry;
import com.example.productinterview.Repository.CounterEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterEntryService {
    @Autowired
    CounterEntryRepository repository;

    @Autowired
    Counter counter;

    public void changeCounter(int diff){
        counter.setCounter(diff);
        int finalCount = counter.getCounter().get();
        if(finalCount == 0 || finalCount == 100) {
            CounterEntry entry = new CounterEntry();
            entry.setCounter(finalCount);
            repository.save(entry);
        }
    }
}
