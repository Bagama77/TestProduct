package com.example.productinterview.Model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Component
@Scope("prototype")
public class ThreadChangeRequest {
    @Id
    @GeneratedValue
    private long id;

    @DateTimeFormat
    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "increaseProducers")
    private int increaseProducers;

    @Column(name = "increaseConsumers")
    private int increaseConsumers;
}
