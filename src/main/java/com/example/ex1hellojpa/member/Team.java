package com.example.ex1hellojpa.member;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Team {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "MEMBER_ID")
    Long id;
    String name;
}
