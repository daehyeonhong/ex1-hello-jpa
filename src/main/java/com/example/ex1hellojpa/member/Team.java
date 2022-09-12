package com.example.ex1hellojpa.member;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
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
    /*
    다:1 매핑 관계, 1에서 조회 할 때 추가
     */
    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<>();
}
