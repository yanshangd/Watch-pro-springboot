package com.yanshang.watchpro.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "room")
@Data
@EntityListeners(AuditingEntityListener.class)

public class RoomPojo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String room;
    private String password;
    private String name;
    private String url;

//    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//    @JoinColumn(name = "room",referencedColumnName = "room")
//    private List<UserPojo> users;
    @Column(name="time",updatable = false,nullable = false)
    @CreatedDate
    private Date time;
}
