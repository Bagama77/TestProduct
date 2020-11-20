package com.example.productinterview.Model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@Scope("prototype")
@Slf4j
public class ConsumerCounter implements Runnable {

    @Autowired
    Counter counter;

    @Override
    public void run() {
        counter.setCounter(-1);
        log.info(String.format("Consumer thread %s decreases counter to %d"),
                this.toString(), counter.getCounter().get());
    }
}
