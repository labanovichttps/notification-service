package com.labanovich.remote.controller;


import com.labanovich.remote.dto.RequestPerson;
import com.labanovich.remote.dto.ResponseFines;
import com.labanovich.remote.service.CommunalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class CommunalController {

    private final CommunalService service;

    @PostMapping("/remote/notification")
    public ResponseFines getCommunalFines(@RequestBody RequestPerson person) throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(3 + 1));
        ResponseFines responseFines = new ResponseFines();
        responseFines.setFines(service.getCommunalFines(person.getPersonName()));
        return responseFines;
    }
}
