package com.labanovich.notification.service;


import com.labanovich.notification.dto.NotificationDTO;
import com.labanovich.remote.dto.RequestPerson;

import java.util.List;

public interface NotificationService {

    List<NotificationDTO> getNotifications(RequestPerson person);
}
