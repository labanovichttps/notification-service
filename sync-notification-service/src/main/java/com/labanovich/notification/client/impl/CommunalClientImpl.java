package com.labanovich.notification.client.impl;

import com.labanovich.notification.client.CommunalClient;
import com.labanovich.remote.dto.RequestPerson;
import com.labanovich.remote.dto.ResponseFines;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CommunalClientImpl implements CommunalClient {

    private final RestTemplate template;

    @Value("${app.remote-service.host}")
    private String url;

    @Override
    public ResponseFines getCommunalFines(RequestPerson person) {
        return template.postForObject(url + "/remote/notification", person, ResponseFines.class);
    }
}
