package com.labanovich.notification.service.impl;

import com.labanovich.notification.client.CommunalClient;
import com.labanovich.notification.dto.NotificationDTO;
import com.labanovich.notification.mapper.NotificationMapper;
import com.labanovich.notification.repository.mongo.FineRepository;
import com.labanovich.notification.repository.postgres.TaxRepository;
import com.labanovich.notification.service.NotificationService;
import com.labanovich.remote.dto.RequestPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final TaxRepository taxRepository;
    private final FineRepository fineRepository;
    private final CommunalClient communalClient;
    private final NotificationMapper mapper;

    @Override
    public List<NotificationDTO> getNotifications(RequestPerson person) {
        List<NotificationDTO> taxs = taxRepository.findAll().stream()
                .filter(tax -> person.getPersonName().equals(tax.getPersonName()))
                .map(mapper::toNotification)
                .toList();
        List<NotificationDTO> fines = fineRepository.findAll().stream()
                .filter(fine -> person.getPersonName().equals(fine.getPersonName()))
                .map(mapper::toNotification)
                .toList();
        List<NotificationDTO> collect = communalClient.getCommunalFines(person).getFines().stream()
                .map(mapper::toNotification)
                .toList();
        List<NotificationDTO> notifications = new ArrayList<>();
        notifications.addAll(taxs);
        notifications.addAll(fines);
        notifications.addAll(collect);
        return notifications;
    }
}
