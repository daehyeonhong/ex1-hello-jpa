package com.example.ex1hellojpa.member;

import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

@Entity(name = "Member")
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
@SequenceGenerator(name = "MEMBER_SEQUENCE_GENERATOR", sequenceName = "MEMBER_SEQUENCE", allocationSize = 1)
public class Member {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "MEMBER_SEQUENCE_GENERATOR")
    Long id;
    @Column(unique = true, length = 10, updatable = false)
    String name;
}
