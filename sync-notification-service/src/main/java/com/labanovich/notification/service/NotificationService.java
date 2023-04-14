package com.labanovich.notification.service;


import com.labanovich.notification.dto.NotificationDTO;
import com.labanovich.remote.dto.RequestPerson;
import reactor.core.publisher.Flux;

public interface NotificationService {

    Flux<NotificationDTO> getNotifications(RequestPerson person);
}
