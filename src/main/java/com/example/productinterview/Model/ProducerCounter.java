package com.example.productinterview.Model;

import com.example.productinterview.service.CounterEntryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@Data
@Scope("prototype")
@Slf4j
public class ProducerCounter implements Runnable {
    @Autowired
    Counter counter;

    @Autowired
    CounterEntryService service;

    @Override
    public void run() {
        service.changeCounter(1);
        log.info("Producer Counter " + this.hashCode() + " increases counter to "
                + counter.getCounter().get());
    }
}
