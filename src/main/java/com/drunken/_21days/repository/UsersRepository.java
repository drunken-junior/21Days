package com.drunken._21days.repository;

import com.drunken._21days.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Users findByName(String username);

}
