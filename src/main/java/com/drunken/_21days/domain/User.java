package com.drunken._21days.domain;

import com.drunken._21days.domain.enums.UseYn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class User extends BaseTimeEntity {
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

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserHabit> userHabits = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<HabitHistory> habitHistories = new ArrayList<>();

    /* 연관관계 편의 메소드 */

    public void addUserHabit(UserHabit userHabit) {
        userHabit.setUser(userHabit.getUser());
        userHabits.add(userHabit);
    }

    public void addHabitHistory(HabitHistory habitHistory) {
        habitHistory.setUser(habitHistory.getUser());
        habitHistories.add(habitHistory);
    }
}
