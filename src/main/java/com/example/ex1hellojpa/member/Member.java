package com.example.ex1hellojpa.member;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.Id;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@ToString
public class Member {
    @Id
    Long id;
    String name;

    public Member(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }
}