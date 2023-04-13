package com.labanovich.notification.client;

import com.labanovich.remote.dto.RequestPerson;
import com.labanovich.remote.dto.ResponseFines;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommunalClient {

    ResponseFines getCommunalFines(@RequestBody RequestPerson person);
}
