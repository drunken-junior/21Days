package com.drunken._21days.repository;

import com.drunken._21days.domain.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit,Long> {
    Habit findByContent(String content);
}
