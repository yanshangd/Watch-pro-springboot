package com.yanshang.watchpro.controller;

import com.yanshang.watchpro.entity.MsgPojo;
import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.MsgService;
import com.yanshang.watchpro.service.RoomService;
import com.yanshang.watchpro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class Room {
    @Autowired
    private RoomService roomService;
    @Autowired
    private MsgService msgService;
    /**
     * 创建房间
     * @param room
     * @return
     */
    @PostMapping("/add")
    public Result addRom(@RequestBody RoomPojo room){
        boolean data = roomService.add(room);
        return new Result(200,data);
    }

    /**
     * 加入房间
     * @param room
     * @return
     */
    @PostMapping("/join")
    public Result JoinRom(@RequestBody RoomPojo room){
        boolean data = roomService.findRoom(room);
        return new Result(200,data);
    }
//    @PostMapping("/msg")
//    public Result AddMsg(@RequestBody MsgPojo msg){
//        boolean data = msgService.add(msg);
//        return new Result(200,data);
//    }

}
