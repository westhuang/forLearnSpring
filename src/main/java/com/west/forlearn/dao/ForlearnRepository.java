package com.west.forlearn.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "simple_user")
@Qualifier("hibernateRepository")
public interface ForlearnRepository extends JpaRepository<UserEntity, Long> {
    //public UserEntity findOne(Long id);

    //public UserEntity save(UserEntity user);

    @Query(value = "select * from simple_user where Fname=?1", nativeQuery = true)
    public UserEntity findUserByName(String name);
}
