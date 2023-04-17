package com.yanshang.watchpro.dao;

import com.yanshang.watchpro.entity.MsgPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgDao extends JpaRepository<MsgPojo,Long> {
}
