package com.yanshang.watchpro.controller;

import com.yanshang.watchpro.entity.RoomPojo;
import com.yanshang.watchpro.service.MsgService;
import com.yanshang.watchpro.service.RoomService;
import com.yanshang.watchpro.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class Room {
    @Autowired
    private RoomService roomService;
    /**
     * 创建房间
     * @param room
     * @return
     */
    @PostMapping("/add")
    public Result addRom(@RequestBody RoomPojo room){
        Result data = roomService.add(room);
        return data;
    }

    /**
     * 加入房间
     * @param room
     * @return
     */
    @PostMapping("/join")
    public Result JoinRom(@RequestBody RoomPojo room){
        Result data = roomService.findRoom(room);
        return data;
    }

    /**
     * 房间用户为0，则删除房间
     * @return
     */
    @GetMapping("/del")
    public Result DelRom(){
        Map<String, Set<String>> map = Result.userByRoom;
        for (String room: map.keySet()) {
            if (map.get(room).isEmpty()) {
                map.remove(room);
                roomService.delRoom(room);
            }
        }
        return new Result(200,"成功");
    }
//    @PostMapping("/msg")
//    public Result AddMsg(@RequestBody MsgPojo msg){
//        boolean data = msgService.add(msg);
//        return new Result(200,data);
//    }

}
