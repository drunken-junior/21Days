package com.drunken._21days.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Habit {
    @Id @GeneratedValue
    @Column(name = "habit_id")
    private Long id;

    private String content;
    private HabitStatus habitStatus;

    private LocalDateTime endDate;

    private UseYn useYn;

    private Long regUser;
    private Long modUser;
}
