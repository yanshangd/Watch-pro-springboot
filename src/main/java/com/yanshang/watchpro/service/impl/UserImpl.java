package com.yanshang.watchpro.service.impl;

import com.yanshang.watchpro.dao.RoomDao;
import com.yanshang.watchpro.dao.UserDao;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.entity.UserPojo;
import com.yanshang.watchpro.service.UserService;
import com.yanshang.watchpro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;
    @Override
    public Object add(String roomId,String name) {
        try {
            UserPojo user=new UserPojo();
            user.setRoom(roomId);
            user.setName(name);
            userDao.save(user);
            RoomPojo room = roomDao.findByRoom(roomId);

            Map<String, String> reMsg = new HashMap<>();
            if(room.getName().equals(name)){
                reMsg.put("admin","admin");
            }
            reMsg.put("url",room.getUrl());
            reMsg.put("msg","" + name + "加入房间");
            Result result=new Result(1002,reMsg , "msg");
            return result;
        } catch (Exception e) {
            // e.printStackTrace();
            return new Result(201,"错误");
        }
    }

    @Override
    public Object del(String name) {
        try {
          userDao.deleteByName(name);
            Map<String, String> reMsg = new HashMap<>();
            reMsg.put("msg","" + name + "离开房间");
            Result result=new Result(1003, reMsg, "msg");
//            System.out.print(data);
            return result;

        } catch (Exception e) {
            // e.printStackTrace();
            return new Result(201,"错误");
        }
    }
}
