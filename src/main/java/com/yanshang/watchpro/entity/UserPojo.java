package com.yanshang.watchpro.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class UserPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String room;
    private String name;
    @Column(name="time",updatable = false,nullable = false)
    @CreatedDate
    private Date time;

    @Override
    public String toString() {
        return "" + name + "";
    }
}
