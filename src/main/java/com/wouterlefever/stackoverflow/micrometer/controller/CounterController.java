package com.wouterlefever.stackoverflow.micrometer.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    private final Counter counter;

    public CounterController() {
        this.counter = Metrics.counter("numberOfGets");

    }

    @GetMapping
    void increaseCounter() {
        counter.increment();
    }
}
