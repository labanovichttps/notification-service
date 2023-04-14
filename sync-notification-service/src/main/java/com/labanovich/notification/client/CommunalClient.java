package com.labanovich.notification.client;

import com.labanovich.remote.dto.CommunalFineDTO;
import com.labanovich.remote.dto.RequestPerson;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CommunalClient {

    Mono<List<CommunalFineDTO>> getCommunalFines(@RequestBody RequestPerson person);
}
