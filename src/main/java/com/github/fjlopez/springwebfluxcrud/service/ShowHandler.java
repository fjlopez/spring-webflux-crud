package com.github.fjlopez.springwebfluxcrud.service;

import com.github.fjlopez.springwebfluxcrud.domain.Show;
import com.github.fjlopez.springwebfluxcrud.repository.ReactiveShowRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ShowHandler {

    private final ReactiveShowRepository showRepository;

    public ShowHandler(ReactiveShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Mono<ServerResponse> all(ServerRequest serverRequest) {
        var shows = showRepository.findAll();
        return ServerResponse.ok().body(shows, Show.class);
    }

    public Mono<ServerResponse> byId(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        var show = showRepository.findById(id);
        return ServerResponse.ok().body(show, Show.class);
    }
}
