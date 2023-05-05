<<<<<<< HEAD
package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;


public interface UserDao extends JpaRepository<UserPojo,Long> {

    @Transactional
    Object deleteByName(String name);

}
=======
package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;


public interface UserDao extends JpaRepository<UserPojo,Long> {

    @Transactional
    Object deleteByName(String name);

}
>>>>>>> 849a8697ec423f3accd259ae7353f77a1982a52c
