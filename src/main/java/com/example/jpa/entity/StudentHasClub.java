package com.example.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student_has_club")
@Getter
@Setter
@SequenceGenerator(name = "student_has_club_seq_generator", sequenceName = "student_has_club_seq", initialValue = 1, allocationSize = 1)
@NamedEntityGraph(name = "studentHasClub", attributeNodes = { @NamedAttributeNode("student"), @NamedAttributeNode("club") })
public class StudentHasClub {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_has_club_seq_generator")
    @Column(name = "student_has_club_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
