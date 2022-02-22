package com.drunken._21days.repository;

import com.drunken._21days.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String username);

}
