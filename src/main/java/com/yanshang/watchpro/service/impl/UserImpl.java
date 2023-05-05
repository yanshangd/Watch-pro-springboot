<<<<<<< HEAD
package com.yanshang.watchpro.service.impl;

import com.yanshang.watchpro.dao.RoomDao;
import com.yanshang.watchpro.dao.UserDao;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.UserService;
import com.yanshang.watchpro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;
    @Override
    public Object add(String roomId,String name) {
        try {
//            UserPojo user=new UserPojo();
//            user.setRoom(roomId);
//            user.setName(name);
//            userDao.save(user);
            //获取用户列表
            Map<String, Set<String>> map = Result.userByRoom;
            Set<String> list = new HashSet<>();
            list.add(name);
            if (!map.containsKey(roomId)) //房间不存在
            {
                map.put(roomId,list);
            }else {                         //存在则循环添加用户
                for (int i = 0; i < map.get(roomId).size(); i++) {
                    list.addAll(map.get(roomId));
                }
                map.put(roomId,list);
            }
            System.out.println(map);
            //获取房间信息
            RoomPojo room = roomDao.findByRoom(roomId);
            Map<String, String> reMsg = new HashMap<>();
//            if(room.getName().equals(name)){
//                reMsg.put("admin","admin");
//            }
            reMsg.put("url",room.getUrl());
            reMsg.put("name",name);
            reMsg.put("msg","" + name + "加入房间");
            Result result=new Result(1002,reMsg , "msg");
            return result;
        } catch (Exception e) {
            // e.printStackTrace();
            return new Result(201,"错误");
        }
    }

    @Override
    public Object del(String room,String name) {
        try {
//            userDao.deleteByName(name);
            //删除用户
            Map<String, Set<String>> map = Result.userByRoom;
            map.get(room).remove(name);
            //用户为0，删除房间,不可取
//            if(map.get(room).isEmpty()){
//                roomDao.deleteByRoom(room);
//                map.remove(room);
//                return "false";
//            }
            //返回参数
            Map<String, String> reMsg = new HashMap<>();
            reMsg.put("msg","" + name + "离开房间");
            Result result=new Result(1003, reMsg, "msg");
            return result;

        } catch (Exception e) {
            // e.printStackTrace();
            return new Result(201,"错误");
        }
    }
}
=======
package com.yanshang.watchpro.service.impl;

import com.yanshang.watchpro.dao.RoomDao;
import com.yanshang.watchpro.dao.UserDao;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.UserService;
import com.yanshang.watchpro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;
    @Override
    public Object add(String roomId,String name) {
        try {
//            UserPojo user=new UserPojo();
//            user.setRoom(roomId);
//            user.setName(name);
//            userDao.save(user);
            //获取用户列表
            Map<String, Set<String>> map = Result.userByRoom;
            Set<String> list = new HashSet<>();
            list.add(name);
            if (!map.containsKey(roomId)) //房间不存在
            {
                map.put(roomId,list);
            }else {                         //存在则循环添加用户
                for (int i = 0; i < map.get(roomId).size(); i++) {
                    list.addAll(map.get(roomId));
                }
                map.put(roomId,list);
            }
            System.out.println(map);
            //获取房间信息
            RoomPojo room = roomDao.findByRoom(roomId);
            Map<String, String> reMsg = new HashMap<>();
//            if(room.getName().equals(name)){
//                reMsg.put("admin","admin");
//            }
            reMsg.put("url",room.getUrl());
            reMsg.put("name",name);
            reMsg.put("msg","" + name + "加入房间");
            Result result=new Result(1002,reMsg , "msg");
            return result;
        } catch (Exception e) {
            // e.printStackTrace();
            return new Result(201,"错误");
        }
    }

    @Override
    public Object del(String room,String name) {
        try {
//            userDao.deleteByName(name);
            //删除用户
            Map<String, Set<String>> map = Result.userByRoom;
            map.get(room).remove(name);
            //用户为0，删除房间,不可取
//            if(map.get(room).isEmpty()){
//                roomDao.deleteByRoom(room);
//                map.remove(room);
//                return "false";
//            }
            //返回参数
            Map<String, String> reMsg = new HashMap<>();
            reMsg.put("msg","" + name + "离开房间");
            Result result=new Result(1003, reMsg, "msg");
            return result;

        } catch (Exception e) {
            // e.printStackTrace();
            return new Result(201,"错误");
        }
    }
}
>>>>>>> 849a8697ec423f3accd259ae7353f77a1982a52c
