package com.example.ex1hellojpa.member;

import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import static javax.persistence.GenerationType.TABLE;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
@TableGenerator(
        name = "MEMBER_SEQUENCE_GENERATOR",
        table = "MEMBER_SEQUENCE",
        allocationSize = 1)
public class Member {
    @Id
    @GeneratedValue(strategy = TABLE, generator = "MEMBER_SEQUENCE_GENERATOR")
    Long id;
    @Column(unique = true, length = 10, updatable = false)
    String name;
}
