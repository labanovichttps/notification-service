package com.labanovich.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommunalFineDTO {

    private Long id;

    private String type;

    private String name;

    private String personName;

    private Instant createTime = Instant.now();

}
