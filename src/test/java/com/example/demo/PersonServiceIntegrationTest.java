package com.example.demo;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonServiceIntegrationTest {

    @Autowired
    PersonService service;

    @Test
    void createAndFind() {
        PersonDTO dto = new PersonDTO(null, "Grace", "Hopper", "grace@example.com");
        PersonDTO created = service.create(dto);
        assertThat(created.getId()).isNotNull();

        PersonDTO fetched = service.findById(created.getId()).orElseThrow();
        assertThat(fetched.getEmail()).isEqualTo("grace@example.com");

        service.delete(created.getId());
        assertThat(service.findById(created.getId())).isEmpty();
    }
}