package com.yanshang.watchpro.service;

import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.utils.Result;

import java.util.List;

public interface RoomService {
    Result add(RoomPojo room);
    Result findRoom(RoomPojo room);
    Object findByRoom(String room);
    Object delRoom(String room);
    void updateUrlByRoom(String url,String room);
}
