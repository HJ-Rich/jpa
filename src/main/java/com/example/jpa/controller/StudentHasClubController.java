package com.example.jpa.controller;

import com.example.jpa.entity.StudentHasClub;
import com.example.jpa.repository.StudentHasClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentHasClub")
@RequiredArgsConstructor
public class StudentHasClubController {

    private final StudentHasClubRepository studentHasClubRepository;

    @GetMapping
    public List<StudentHasClub> findAll() {
        return studentHasClubRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudentHasClub findById(@PathVariable Long id) {
        return studentHasClubRepository.findById(id).get();
    }

    @PostMapping
    public StudentHasClub save(@RequestBody StudentHasClub studentHasClub) {
        return studentHasClubRepository.save(studentHasClub);
    }

    @PatchMapping
    public StudentHasClub update(@RequestBody StudentHasClub studentHasClub) {
        return studentHasClubRepository.save(studentHasClub);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentHasClubRepository.deleteById(id);
    }

}
