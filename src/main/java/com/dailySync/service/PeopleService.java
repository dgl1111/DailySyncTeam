package com.dailySync.service;

import com.dailySync.dto.PeopleReqDto;
import com.dailySync.dto.PeopleResDto;
import com.dailySync.entities.People;
import com.dailySync.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeopleService {
    final private PeopleRepository peopleRepository;

    public List<PeopleResDto> getAllPeople(){
        return peopleRepository.findAll()
                .stream().map(PeopleResDto::of)
                .collect(Collectors.toList());
    }

    public PeopleResDto getPeopleById(Long id){
        People people = peopleRepository.findById(id).orElse(null);
        return PeopleResDto.of(people);
    }

    public People createPeople(PeopleReqDto reqDto) {
        People people = People.builder()
                .username(reqDto.getUsername())
                .email(reqDto.getEmail())
                .build();
        return peopleRepository.save(people);
    }

    public void deletePeople(Long id){
        peopleRepository.deleteById(id);
    }
}