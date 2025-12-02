package com.example.demo.service;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    private PersonDTO toDTO(Person p) {
        return new PersonDTO(p.getId(), p.getFirstName(), p.getLastName(), p.getEmail());
    }

    private Person fromDTO(PersonDTO dto) {
        Person p = new Person();
        p.setFirstName(dto.getFirstName());
        p.setLastName(dto.getLastName());
        p.setEmail(dto.getEmail());
        return p;
    }

    public List<PersonDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<PersonDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    public PersonDTO create(PersonDTO dto) {
        Person p = fromDTO(dto);
        Person saved = repository.save(p);
        return toDTO(saved);
    }

    public Optional<PersonDTO> update(Long id, PersonDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setFirstName(dto.getFirstName());
            existing.setLastName(dto.getLastName());
            existing.setEmail(dto.getEmail());
            Person saved = repository.save(existing);
            return toDTO(saved);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}