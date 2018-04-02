package com.github.fjlopez.springwebfluxcrud.service;

import com.github.fjlopez.springwebfluxcrud.domain.ShowEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShowEventHandlerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testShowEventsIsOk() {
        webTestClient
                .get().uri("/shows/2/events")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testShowEventsResult() {
        FluxExchangeResult<ShowEvent> result = webTestClient
                .get().uri("/shows/2/events")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(ShowEvent.class);

        var eventFlux = result.getResponseBody();

        StepVerifier.create(eventFlux)
                .expectNextCount(10)
                .assertNext(s -> assertThat(s.getId()).isEqualTo("2"))
                .thenCancel()
                .verify();
    }
}

