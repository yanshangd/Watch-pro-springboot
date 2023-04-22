package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.RoomPojo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomDao extends JpaRepository<RoomPojo,Long> {
    RoomPojo findByRoomAndPassword(String room_id,String password);
    RoomPojo findByRoom(String room_id);

    @Transactional
    Object deleteByRoom(String room);
}
