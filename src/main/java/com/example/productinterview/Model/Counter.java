package com.example.productinterview.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Data
public class Counter {
    private final AtomicInteger counter = new AtomicInteger(50);

    public synchronized int setCounter(int diff) {
        return this.counter.addAndGet(diff);
    }
}
