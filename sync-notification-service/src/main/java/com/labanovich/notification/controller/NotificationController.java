package com.labanovich.notification.controller;

import com.labanovich.notification.dto.NotificationDTO;
import com.labanovich.notification.service.NotificationService;
import com.labanovich.remote.dto.RequestPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @GetMapping("/notifications")
    public List<NotificationDTO> getNotifications(RequestPerson requestPerson) {
        return service.getNotifications(requestPerson);
    }
}
