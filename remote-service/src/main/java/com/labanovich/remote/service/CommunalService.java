package com.labanovich.remote.service;


import com.labanovich.remote.dto.CommunalFineDTO;

import java.util.List;

public interface CommunalService {

    List<CommunalFineDTO> getCommunalFines(String personName);
}
