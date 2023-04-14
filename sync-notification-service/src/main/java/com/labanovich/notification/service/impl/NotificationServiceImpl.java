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
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final TaxRepository taxRepository;
    private final FineRepository fineRepository;
    private final CommunalClient communalClient;
    private final NotificationMapper mapper;


    @Override
    public Flux<NotificationDTO> getNotifications(RequestPerson person) {
        return taxRepository.findAllByPersonName(person.getPersonName())
            .map(mapper::toNotification)
            .concatWith(fineRepository.findAllByPersonName(person.getPersonName())
                .filter(fine -> person.getPersonName().equals(fine.getPersonName()))
                .map(mapper::toNotification))
            .concatWith(communalClient.getCommunalFines(person).flatMapIterable(res -> res)
                .map(mapper::toNotification));
    }
}
