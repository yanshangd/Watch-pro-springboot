package com.yanshang.watchpro.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "msg_chat")
@Data
@EntityListeners(AuditingEntityListener.class)

public class MsgPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String roomid;
    private String name;
    private String msg;
    @Column(name="time",updatable = false,nullable = false)
    @CreatedDate
    private Date time;
}