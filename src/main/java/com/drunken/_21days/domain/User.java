package com.drunken._21days.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User extends BaseTimeEntity{
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private UseYn useYn; //Y, N

    private Long regUser;
    private Long modUser;

    @OneToMany(mappedBy = "user")
    private List<UserHabit> userHabits = new ArrayList<>();
}
