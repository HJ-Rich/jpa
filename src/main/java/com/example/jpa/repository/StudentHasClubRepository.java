package com.example.jpa.repository;

import com.example.jpa.entity.Student;
import com.example.jpa.entity.StudentHasClub;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentHasClubRepository extends JpaRepository<StudentHasClub, Long> {

    @EntityGraph("studentHasClub")
    List<StudentHasClub> findByStudent(Student student);

}
