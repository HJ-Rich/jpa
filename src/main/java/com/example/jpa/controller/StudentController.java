package com.example.jpa.controller;

import com.example.jpa.entity.Club;
import com.example.jpa.entity.Student;
import com.example.jpa.entity.StudentHasClub;
import com.example.jpa.repository.StudentHasClubRepository;
import com.example.jpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentHasClubRepository studentHasClubRepository;

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable Long id) {
        Student student = studentRepository.findById(id).get();
        List<StudentHasClub> studentHasClubList = studentHasClubRepository.findByStudent(student);
        List<Club> clubList = studentHasClubList.stream().map(e -> e.getClub()).collect(Collectors.toList());
        student.setClubList(clubList);

        Map map = new HashMap();
        map.put("result", student);
        return map;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PatchMapping
    public Student update(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

}
