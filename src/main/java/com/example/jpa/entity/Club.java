package com.example.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "club")
@Getter
@Setter
@SequenceGenerator(name = "club_seq_generator", sequenceName = "club_seq", initialValue = 1, allocationSize = 1)
public class Club {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq_generator")
    @Column(name = "club_id")
    private Long id;

    @Column(name = "club_name")
    private String name;

}
