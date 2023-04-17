package com.yanshang.watchpro;

import com.alibaba.fastjson.JSONObject;
import com.yanshang.watchpro.dao.RoomDao;
import com.yanshang.watchpro.dao.UserDao;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResourcesApplicationTests {
@Autowired
private UserService userService;
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.deleteByName("12"));
    }

}
