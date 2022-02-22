package com.drunken._21days.domain;

import com.drunken._21days.domain.enums.UseYn;
import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter @Setter
public class UserHabit extends BaseTimeEntity{
    @Id @GeneratedValue
    @Column(name = "user_habit_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @Enumerated(EnumType.STRING)
    private UseYn useYn;

    private long regUser;
    private long modUser;
}
