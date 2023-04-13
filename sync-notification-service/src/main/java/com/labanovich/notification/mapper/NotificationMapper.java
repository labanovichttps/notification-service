package com.labanovich.notification.mapper;

import com.labanovich.notification.dto.NotificationDTO;
import com.labanovich.notification.model.Fine;
import com.labanovich.notification.model.Tax;
import com.labanovich.remote.dto.CommunalFineDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper {

    NotificationDTO toNotification(Tax tax);

    NotificationDTO toNotification(Fine fine);

    NotificationDTO toNotification(CommunalFineDTO communalFineDTO);
}
