package com.drunken._21days.repository;

import com.drunken._21days.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    HabitRepository habitRepository;

    @DisplayName("user 생성 테스트")
    @Test
    void create() {
        Users user1 = Users.builder().name("user1").email("test@21day.com").useYn(UseYn.Y).regUser(1L).modUser(1L).build();
        usersRepository.save(user1);

        List<Users> users = usersRepository.findAll();
        assertThat(users.size()).isEqualTo(1);

        Users findUser = usersRepository.findByName("user1");
        assertThat(user1).isEqualTo(findUser);
    }

/* TODO: 전체적인 편의메서드 어떻게 작성할건지 설계 후 작성하기

    @DisplayName("연관관계 편의 메서드 테스트")
    @Test
    void addHabitUserTest() {
        Users user1 = Users.builder().name("user1").email("test@21day.com").useYn(UseYn.Y).regUser(1L).modUser(1L).build();
        usersRepository.save(user1);
        Habit habit = Habit.builder().content("10분 스트레칭").habitStatus(HabitStatus.START).build();
        UserHabit userHabit = UserHabit.builder().habit(habit).users(user1).build();
        habitRepository.save(habit);
        user1.addUserHabit(userHabit);

        Users findUser = usersRepository.findByName("user1");

        assertThat(findUser.getUserHabits().get(0).getHabit().getContent())
                .isEqualTo("10분 스트레칭");

        Habit findHabit = habitRepository.findByContent("10분 스트레칭");
        assertThat(findHabit.getHabitStatus()).isEqualTo(HabitStatus.PROCEEDING);
        assertThat(findHabit.getHabitHistoryList().get(0).getUsers().getName()).isEqualTo("user1");

    }
*/
}