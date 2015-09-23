package com.rl.dao;

import com.rl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



/**
 * Created by zhangrunlin on 2015/09/08.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select s from User s where s.name = ?1")
    public User findUserByName(String name);
}
