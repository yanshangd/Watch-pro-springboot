package com.yanshang.watchpro.service.impl;

import com.yanshang.watchpro.dao.MsgDao;
import com.yanshang.watchpro.entity.MsgPojo;
import com.yanshang.watchpro.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgImpl implements MsgService {
    @Autowired
    private MsgDao msgDao;

    @Override
    public boolean add(String room, String name, String msg) {
        MsgPojo msgPojo=new MsgPojo();
        msgPojo.setRoomid(room);
        msgPojo.setName(name);
        msgPojo.setMsg(msg);
        try {
            msgDao.save(msgPojo);
            return true;
        } catch (Exception e) {
            // e.printStackTrace();
            return false;
        }
    }
}
