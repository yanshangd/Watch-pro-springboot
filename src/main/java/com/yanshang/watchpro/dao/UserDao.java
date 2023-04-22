package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;


public interface UserDao extends JpaRepository<UserPojo,Long> {

    @Transactional
    Object deleteByName(String name);

}
