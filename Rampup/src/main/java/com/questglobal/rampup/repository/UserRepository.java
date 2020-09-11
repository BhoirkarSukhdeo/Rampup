package com.questglobal.rampup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questglobal.rampup.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
