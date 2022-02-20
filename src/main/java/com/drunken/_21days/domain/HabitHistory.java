package com.drunken._21days.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class HabitHistory {

    @Id @GeneratedValue
    @Column(name = "hist_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    private HabitStatus habitStatus;

    private LocalDateTime historyDate;
}
