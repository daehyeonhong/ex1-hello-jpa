package com.example.ex1hellojpa.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
public class Locker {
    @Id
    Long id;
    String name;
    @OneToOne(mappedBy = "locker")
    Member member;
}
