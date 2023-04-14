package com.labanovich.notification.controller;

import com.labanovich.notification.dto.NotificationDTO;
import com.labanovich.notification.service.NotificationService;
import com.labanovich.remote.dto.RequestPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @GetMapping(value = "/notifications", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NotificationDTO> getNotifications(RequestPerson requestPerson) {
        return service.getNotifications(requestPerson);
    }
}
