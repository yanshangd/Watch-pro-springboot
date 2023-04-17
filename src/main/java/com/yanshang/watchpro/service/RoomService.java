package com.yanshang.watchpro.service;

import com.yanshang.watchpro.entity.RoomPojo;

import java.util.List;

public interface RoomService {
    boolean add(RoomPojo room);
    boolean findRoom(RoomPojo room);
    RoomPojo findByRoom(String room);
}
