package com.sop.lab10.gatewayservice.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;


@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/movie/getMovieByName",
            "/movie/getAllMovies",
            "/movie/getMovieById",
            "/auth/signup",
            "/auth/login",
            "/review/getReview"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
