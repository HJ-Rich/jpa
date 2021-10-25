package com.example.jpa.controller;

import com.example.jpa.entity.Club;
import com.example.jpa.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubRepository clubRepository;

    @GetMapping
    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    @GetMapping("/{id}")
    public Club findById(@PathVariable Long id) {
        return clubRepository.findById(id).get();
    }

    @PostMapping
    public Club save(@RequestBody Club club) {
        return clubRepository.save(club);
    }

    @PatchMapping
    public Club update(@RequestBody Club club) {
        return clubRepository.save(club);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clubRepository.deleteById(id);
    }



}
