package com.labanovich.notification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tax")
public class Tax implements Serializable {

    @Id
    @Column("id")
    private Long id;

    @Column("type")
    private String type;

    @Column("name")
    private String name;

    @Column("person_name")
    private String personName;

    @Column("create_time")
    private Instant createTime;
}
