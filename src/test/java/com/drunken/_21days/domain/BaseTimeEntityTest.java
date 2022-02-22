package com.drunken._21days.domain;

import com.drunken._21days.domain.enums.UseYn;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class BaseTimeEntityTest {
    @Autowired
    EntityManager em;

    @DisplayName("regDate 생성 테스트")
    @Test
    void regDateTest() {
        LocalDate today = LocalDate.now();

        User user1 = User.builder().name("user1").email("test@21day.com").useYn(UseYn.Y).regUser(1L).modUser(1L).build();
        em.persist(user1);

        assertThat(user1.getRegDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .isEqualTo(today.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    @DisplayName("modDate 생성 테스트")
    @Test
    void modDateTest() {
        LocalDateTime today = LocalDateTime.now();

        User user1 = User.builder().name("user1").email("test@21day.com").useYn(UseYn.Y).regUser(1L).modUser(1L).build();
        em.persist(user1);

        LocalDateTime modDate = user1.getModDate();

        // 이 코드 실행하는 동안 분,초가 바뀌어버릴 수 있을까?
        /*
        assertThat(modDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .isEqualTo(today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        */

        assertThat(ChronoUnit.YEARS.between(today, modDate)).isEqualTo(0);
        assertThat(ChronoUnit.MONTHS.between(today, modDate)).isEqualTo(0);
        assertThat(ChronoUnit.WEEKS.between(today, modDate)).isEqualTo(0);
        assertThat(ChronoUnit.DAYS.between(today, modDate)).isEqualTo(0);
        assertThat(ChronoUnit.HOURS.between(today, modDate)).isEqualTo(0);
        assertThat(ChronoUnit.MINUTES.between(today, modDate)).isEqualTo(0);
        assertThat(ChronoUnit.SECONDS.between(today, modDate)).isEqualTo(0);

    }
}