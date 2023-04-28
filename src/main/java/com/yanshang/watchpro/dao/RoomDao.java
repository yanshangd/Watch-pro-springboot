package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.RoomPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomDao extends JpaRepository<RoomPojo,Long> {
    RoomPojo findByRoomAndPassword(String room_id,String password);
    RoomPojo findByRoom(String room_id);

    @Transactional
    Object deleteByRoom(String room);

    @Query(value = "update RoomPojo m set m.url=:url where m.room= :room")
    @Modifying
    void updateUrlByRoom(@Param("url")String url, @Param("room")String room);
}
