package com.drunken._21days.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private UseYn useYn; //Y, N

    private Long regUser;
    private Long modUser;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<UserHabit> userHabits = new ArrayList<>();

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<HabitHistory> habitHistories = new ArrayList<>();

    /* 연관관계 편의 메소드 */

    public void addUserHabit(UserHabit userHabit) {
        userHabit.setUsers(userHabit.getUsers());
        userHabits.add(userHabit);
    }

    public void addHabitHistory(HabitHistory habitHistory) {
        habitHistory.setUsers(habitHistory.getUsers());
        habitHistories.add(habitHistory);
    }
}
