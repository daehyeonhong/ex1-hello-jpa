package com.example.ex1hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.Id;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class Member {
    @Id
    Long id;
    String name;
}
