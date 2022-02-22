package com.drunken._21days.domain;

import com.drunken._21days.domain.enums.HabitStatus;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter @Setter
public class HabitHistory extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "hist_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @Enumerated(EnumType.STRING)
    private HabitStatus habitStatus;

    private LocalDateTime historyDate; // yyyyMMdd String? 아니면 D+day 형태?
}
