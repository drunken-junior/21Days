package com.drunken._21days.domain;

import com.drunken._21days.domain.enums.HabitStatus;
import com.drunken._21days.domain.enums.UseYn;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter @Setter
public class Habit extends BaseTimeEntity{
    @Id @GeneratedValue
    @Column(name = "habit_id")
    private Long id;

    //@NotNull
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
