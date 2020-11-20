package com.example.productinterview.Repository;

import com.example.productinterview.Model.Counter;
import com.example.productinterview.Model.CounterEntry;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories(basePackages = "com.example.productinterview.Repository")
public interface CounterEntryRepository extends CrudRepository<CounterEntry, Long> {
}
