package com.eprakash.learn.microservices.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eprakash.learn.microservices.user.domain.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
