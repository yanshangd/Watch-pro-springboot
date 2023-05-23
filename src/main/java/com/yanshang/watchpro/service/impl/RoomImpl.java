package com.yanshang.watchpro.service.impl;

import com.yanshang.watchpro.dao.RoomDao;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.RoomService;
import com.yanshang.watchpro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public Result add(RoomPojo room) {
        try {
            Object is_room = roomDao.findByRoom(room.getRoom());
            if (is_room!=null){
                Result result=new Result(200,false,"房间号已存在");
                return result;
            }
             RoomPojo name = roomDao.findByName(room.getName());
        if(name!=null){
            Result result=new Result(200,false, "昵称已存在");
            return result;
        }
            roomDao.save(room);
            Result result=new Result(200 ,true,"创建成功");
            return result;
        } catch (Exception e) {
            // e.printStackTrace();
            Result result=new Result(200,false, "错误");
            return result;
        }
    }

    @Override
    public Result findRoom(RoomPojo room) {
        RoomPojo roomId=roomDao.findByRoom(room.getRoom());
        if(roomId.getPassword().isEmpty()){
            Result result=new Result(200,true , "加入成功");
            return result;
        }
        RoomPojo name = roomDao.findByName(room.getName());
        if(name!=null){
            Result result=new Result(200,false, "昵称已存在");
            return result;
        }
        RoomPojo data = roomDao.findByRoomAndPassword(room.getRoom(), room.getPassword());
        if (data==null){
            Result result=new Result(200,false, "房间号或密码错误");
            return result;
        }
        Result result=new Result(200,true , "加入成功");
        return result;

    }

    @Override
    public Object findByRoom(String room) {
        Object data = roomDao.findByRoom(room);
        return data;
    }

    @Override
    public Object delRoom(String room) {
        Object data = roomDao.deleteByRoom(room);
        return data;
    }

    @Override
    public void updateUrlByRoom(String url, String room) {
        roomDao.updateUrlByRoom(url,room);
    }
}
