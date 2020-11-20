package com.example.productinterview.Controller;

import com.example.productinterview.service.ConsumerService;
import com.example.productinterview.service.CounterEntryService;
import com.example.productinterview.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counts")
public class CounterController {

    @Autowired
    ProducerService producerService;

    @Autowired
    ConsumerService consumerService;

    @Autowired
    CounterEntryService counterEntryService;

    @GetMapping("/{increaseProducer}{increaseConsumer}")
    public HttpStatus increaseThreads(@PathVariable Integer increaseProducer,
                                          @PathVariable Integer increaseConsumer) {

        producerService.getProducers(increaseProducer);
        consumerService.getConsumers(increaseConsumer);

        return HttpStatus.CREATED;
    }

    @GetMapping("/change/{diff}")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus change(@PathVariable Integer diff) {
        counterEntryService.changeCounter(diff);
        return HttpStatus.OK;
    }
}
