package com.example.productinterview.Model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
@Slf4j
public class ProducerCounter implements Runnable {
    @Autowired
    Counter counter;

    @Override
    public void run() {
        counter.setCounter(1);
        log.info(String.format("Producer thread %s increases counter to %d"),
                this.toString(), counter.getCounter().get());
    }
}
