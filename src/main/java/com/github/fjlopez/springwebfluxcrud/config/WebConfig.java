package com.github.fjlopez.springwebfluxcrud.config;

import com.github.fjlopez.springwebfluxcrud.service.ShowEventHandler;
import com.github.fjlopez.springwebfluxcrud.service.ShowHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> routeShow(ShowHandler showHandler, ShowEventHandler showEventHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/shows/{id}/events"), showEventHandler::events)
                .andRoute(RequestPredicates.GET("/shows/{id}"), showHandler::byId)
                .andRoute(RequestPredicates.GET("/shows"), showHandler::all);
    }
}
