package com.drunken._21days.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UserHabit extends BaseTimeEntity{
    @Id @GeneratedValue
    @Column(name = "user_habit_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @Enumerated(EnumType.STRING)
    private UseYn useYn;

    private long regUser;
    private long modUser;
}
