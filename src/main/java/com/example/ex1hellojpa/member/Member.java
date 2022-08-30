package com.example.ex1hellojpa.member;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;
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
    @Column(unique = true, length = 10, name = "name")
    String username;
    Integer age;
    @Enumerated(EnumType.STRING)
    RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    Date lastModifiedDate;
    @Lob
    String description;
    @Transient
    int temp;

    public Member(final Long id, final String username) {
        this.id = id;
        this.username = username;
    }
}
