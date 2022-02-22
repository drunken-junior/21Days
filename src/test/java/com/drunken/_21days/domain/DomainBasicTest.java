package com.drunken._21days.domain;

import com.drunken._21days.domain.enums.HabitStatus;
import com.drunken._21days.repository.HabitHistoryRepository;
import com.drunken._21days.repository.HabitRepository;
import com.drunken._21days.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class DomainBasicTest {

    @Autowired
    EntityManager em;

    @Autowired
    HabitRepository habitRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    HabitHistoryRepository habitHistoryRepository;

    @DisplayName("영속성 컨텍스트 적용 테스트")
    @Test
    void create() {
        Habit habit = createHabit(HabitStatus.START, "스쿼트 100개");
        habitRepository.save(habit);

        User user = createUser("member1", "email");
        userRepository.save(user);

        HabitHistory history = createHabitHistory(habit, habit.getHabitStatus(), LocalDateTime.now(), user);
        habitHistoryRepository.save(history);

        User findUser = userRepository.findByName("member1");
        Habit findHabit = habitRepository.findByContent("스쿼트 100개");
        List<HabitHistory> habitHistories = habitHistoryRepository.findByUser(findUser);

        log.info("habitHistories={}", habitHistories);
        log.info("habitHistories.contains()={}", habitHistories.contains("스쿼트 100개"));

        assertThat(habitHistories).extracting("user").extracting("name").containsExactly("member1");
        assertThat(habitHistories).extracting("user").containsExactly(findUser);
        assertThat(habitHistories).extracting("habit").containsExactly(findHabit);
    }

    private Habit createHabit(HabitStatus status, String content) {
        Habit habit = Habit.builder().habitStatus(status).content(content).build();
        em.persist(habit);
        return habit;
    }

    private User createUser(String name, String email) {
        User user = User.builder().name(name).email(email).build();
        em.persist(user);
        return user;
    }

    private HabitHistory createHabitHistory(Habit habit, HabitStatus status, LocalDateTime date, User user) {
        HabitHistory history = HabitHistory.builder().habit(habit).habitStatus(status).historyDate(date).user(user).build();
        em.persist(history);
        return history;
    }
}