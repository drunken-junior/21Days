package com.drunken._21days.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class HabitHistory extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "hist_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @Enumerated(EnumType.STRING)
    private HabitStatus habitStatus;

    private LocalDateTime historyDate;
}
