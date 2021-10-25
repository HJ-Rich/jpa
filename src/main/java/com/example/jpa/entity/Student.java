package com.example.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@SequenceGenerator(name = "student_seq_generator", sequenceName = "student_seq", initialValue = 1, allocationSize = 1)
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_generator")
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Transient // 아예 제외 엔티티에서 관리 안 함
    private List<Club> clubList = new ArrayList<>();

}
