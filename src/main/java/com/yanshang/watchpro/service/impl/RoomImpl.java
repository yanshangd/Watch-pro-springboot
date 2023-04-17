package com.yanshang.watchpro.service.impl;

import com.yanshang.watchpro.dao.RoomDao;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public boolean add(RoomPojo room) {
        try {
            roomDao.save(room);
            return true;
        } catch (Exception e) {
            // e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean findRoom(RoomPojo room) {
        RoomPojo data = roomDao.findByRoomAndPassword(room.getRoom(), room.getPassword());
        if (data==null){
            return false;
        }
            return true;

    }

    @Override
    public RoomPojo findByRoom(String room) {
        RoomPojo data = roomDao.findByRoom(room);
        return data;
    }
}
