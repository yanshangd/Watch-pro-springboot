package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.function.Function;

public interface UserDao extends JpaRepository<UserPojo,Long> {
    @Modifying
    @Transactional
    Object deleteByName(String name);

}
