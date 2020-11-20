package com.example.productinterview.Controller;

import com.example.productinterview.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counts")
public class CounterController {

    @Autowired
    ThreadService threadService;

    @Autowired
    CounterEntryService counterEntryService;

    @Autowired
    ThreadRequestService threadRequestService;

    @GetMapping("/{increaseProducer}/{increaseConsumer}")
    public HttpStatus increaseThreads(@PathVariable Integer increaseProducer,
                                          @PathVariable Integer increaseConsumer) throws Exception {

        threadRequestService.saveThreadRequest(increaseConsumer, increaseProducer);
        threadService.executeCounterChange(increaseConsumer, increaseProducer);

        return HttpStatus.CREATED;
    }

    @GetMapping("/change/{diff}")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus change(@PathVariable Integer diff) {
        counterEntryService.changeCounter(diff);
        return HttpStatus.OK;
    }
}
