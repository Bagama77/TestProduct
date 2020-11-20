package com.example.productinterview.Model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Component
@Data
@Scope("prototype")
public class CounterEntry {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "counter")
    private int counter;
}
