package com.example.ex1hellojpa.member;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity(name = "Member")
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class Member {
    @Id
    Long id;
    @Column(unique = true, length = 10)
    String name;
    int age;

    public Member(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }
}
