package com.yanshang.watchpro.service;

import com.yanshang.watchpro.utils.Result;

import java.util.List;

public interface UserService {
    Object add(String roomId, String name);
    Object del(String name);

}
