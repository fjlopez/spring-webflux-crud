package com.github.fjlopez.springwebfluxcrud.service;

import com.github.fjlopez.springwebfluxcrud.domain.ShowEvent;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

import static java.time.Duration.ofSeconds;
import static org.springframework.web.reactive.function.BodyInserters.fromServerSentEvents;
import static reactor.core.publisher.Flux.interval;

@Component
public class ShowEventHandler {

    private static final Flux<Long> INTERVAL = interval(ofSeconds(1));


    public Mono<ServerResponse> events(ServerRequest serverRequest) {
        var showId = serverRequest.pathVariable("id");

        var events = INTERVAL
                .map(Object::toString)
                .map(eventId -> createEvent(showId, eventId));

        return ServerResponse
                .ok()
                .body(fromServerSentEvents(events));
    }

    private ServerSentEvent<ShowEvent> createEvent(String dataId, String eventId) {
        return ServerSentEvent
                .builder(new ShowEvent(dataId, new Date()))
                .id(eventId)
                .event("test")
                .build();
    }

}