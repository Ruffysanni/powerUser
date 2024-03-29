package com.ruffy.powerUser.repository;

import com.ruffy.powerUser.entity.PowerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PowerUserRepository extends JpaRepository<PowerUser, Integer> { }
