package com.drunken._21days.repository;

import com.drunken._21days.domain.HabitHistory;
import com.drunken._21days.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitHistoryRepository extends JpaRepository<HabitHistory,Long> {
    List<HabitHistory> findByUser(User user);
}
