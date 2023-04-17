package com.yanshang.watchpro.service;


import com.yanshang.watchpro.entity.MsgPojo;

public interface MsgService {
    boolean add(String room,String name,String msg);
}
