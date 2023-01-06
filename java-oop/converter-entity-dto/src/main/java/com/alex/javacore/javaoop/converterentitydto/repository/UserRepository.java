package com.alex.javacore.javaoop.converterentitydto.repository;

import com.alex.javacore.javaoop.converterentitydto.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
