package com.github.fjlopez.springwebfluxcrud.repository;

import com.github.fjlopez.springwebfluxcrud.domain.Show;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ReactiveShowRepository implements ReactiveCrudRepository<Show, String> {

    private final Map<String, Show> showsMap = new ConcurrentHashMap<>();


    public ReactiveShowRepository() {
        showsMap.put("1", new Show("1", "Title1"));
        showsMap.put("2", new Show("2", "Title2"));
        showsMap.put("3", new Show("3", "Title3"));
        showsMap.put("4", new Show("4", "Title4"));
        showsMap.put("5", new Show("5", "Title5"));
    }

    @Override
    public <S extends Show> Mono<S> save(S entity) {
        return null;
    }

    @Override
    public <S extends Show> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Show> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }

    @Override
    public Mono<Show> findById(String s) {
        return Mono.justOrEmpty(showsMap.get(s));
    }

    @Override
    public Mono<Show> findById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> id) {
        return null;
    }

    @Override
    public Flux<Show> findAll() {
        return Flux.fromIterable(showsMap.values());
    }

    @Override
    public Flux<Show> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public Flux<Show> findAllById(Publisher<String> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Show entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Show> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Show> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
