package com.tom.functional;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.reactive.function.BodyExtractors.toDataBuffers;
import static org.springframework.web.reactive.function.BodyExtractors.toFormData;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class FormHandler {

    Mono<ServerResponse> handleLogin(ServerRequest request) {
        return request.body(toFormData())
                .map(MultiValueMap::toSingleValueMap)
                .filter(formData -> "tom".equals(formData.get("user")))
                .filter(formData -> "you_know_what_to_do".equals(formData.get("token")))
                .flatMap(formData -> ok().body(Mono.just("welcome back!"), String.class))
                .switchIfEmpty(ServerResponse.badRequest()
                        .build());
    }

    Mono<ServerResponse> handleUpload(ServerRequest request) {
        return request.body(toDataBuffers())
                .collectList()
                .flatMap(dataBuffers -> ok().body(fromObject(extractData(dataBuffers).toString())));
    }

    private AtomicLong extractData(List<DataBuffer> dataBuffers) {
        AtomicLong atomicLong = new AtomicLong(0);
        dataBuffers.forEach(d -> atomicLong.addAndGet(d.readableByteCount()));
        return atomicLong;
    }
}
