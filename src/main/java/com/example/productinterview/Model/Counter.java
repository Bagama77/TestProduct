package com.example.productinterview.Model;

import com.example.productinterview.service.CounterEntryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Data
@Scope("singleton")
public class Counter {

    @Autowired
    CounterEntryService service;

    private final AtomicInteger counter = new AtomicInteger(50);

    public synchronized int setCounter(int diff) {
        int result = this.counter.addAndGet(diff);
        if (result == 0 || result == 100) service.changeCounter(diff);
        return this.counter.addAndGet(diff);
    }
}
