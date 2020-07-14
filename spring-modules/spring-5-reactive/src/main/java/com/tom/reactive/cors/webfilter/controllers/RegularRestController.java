package com.tom.reactive.cors.webfilter.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/web-filter-on-annotated")
public class RegularRestController {

    @PutMapping("/regular-put-endpoint")
    public Mono<String> regularPutEndpoint() {
        return Mono.just("Regular PUT endpoint");
    }

    @DeleteMapping("/regular-delete-endpoint")
    public Mono<String> regularDeleteEndpoint() {
        return Mono.just("Regular DELETE endpoint");
    }
}
