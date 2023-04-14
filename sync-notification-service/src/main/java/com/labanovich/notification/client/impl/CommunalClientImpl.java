package com.labanovich.notification.client.impl;

import com.labanovich.notification.client.CommunalClient;
import com.labanovich.remote.dto.CommunalFineDTO;
import com.labanovich.remote.dto.RequestPerson;
import com.labanovich.remote.dto.ResponseFines;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommunalClientImpl implements CommunalClient {

    private final WebClient client;

    @Value("${app.remote-service.host}")
    private String url;

    @Override
    public Mono<List<CommunalFineDTO>> getCommunalFines(RequestPerson person) {
        return client.post()
            .uri(url + "/remote/notification")
            .bodyValue(person)
            .retrieve()
            .bodyToMono(ResponseFines.class)
            .retry()
            .map(ResponseFines::getFines);
    }
}
