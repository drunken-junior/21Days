package com.drunken._21days.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Habit extends BaseTimeEntity{
    @Id @GeneratedValue
    @Column(name = "habit_id")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private HabitStatus habitStatus;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private UseYn useYn;

    private Long regUser;
    private Long modUser;

    @OneToMany(mappedBy = "habit")
    private List<HabitHistory> habitHistoryList = new ArrayList<>();
}
