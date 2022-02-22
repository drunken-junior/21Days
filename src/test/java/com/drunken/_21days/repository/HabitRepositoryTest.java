package com.drunken._21days.repository;

import com.drunken._21days.domain.Habit;
import com.drunken._21days.domain.enums.HabitStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class HabitRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    HabitRepository habitRepository;

    @DisplayName("habit 생성 테스트")
    @Test
    void create() {
        Habit habit = Habit.builder().habitStatus(HabitStatus.START).content("스쿼트 100개").build();
        habitRepository.save(habit);

        List<Habit> habits = habitRepository.findAll();
        assertThat(habits.size()).isEqualTo(1);

        Habit findHabit = habitRepository.findByContent("스쿼트 100개");
        assertThat(habit).isEqualTo(findHabit);
    }

    }