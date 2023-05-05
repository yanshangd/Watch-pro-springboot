package com.yanshang.watchpro.controller;

import com.alibaba.fastjson.JSONObject;
import com.yanshang.watchpro.service.MsgService;
import com.yanshang.watchpro.service.RoomService;
import com.yanshang.watchpro.service.UserService;
import com.yanshang.watchpro.utils.MyApplicationContextUtil;
import com.yanshang.watchpro.utils.Result;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Component
//解决bean注入
@DependsOn("myApplicationContextUtil")
@ServerEndpoint("/online/{roomId}/{name}")
@CrossOrigin
public class WebSocket {
    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    public Session session;
    /**
     * 标识当前连接客户端的房间号
     */
    public String name;
    /**
     * 房间号
     */
    public String roomId;


    //存放所有连接的客户端
    private static ConcurrentHashMap<String, WebSocket> webSocket = new ConcurrentHashMap<>();

    //注入bean
    private UserService userService = MyApplicationContextUtil.getBean(com.yanshang.watchpro.service.UserService.class);
    private RoomService roomService = MyApplicationContextUtil.getBean(com.yanshang.watchpro.service.RoomService.class);
    private MsgService msgService = MyApplicationContextUtil.getBean(com.yanshang.watchpro.service.MsgService.class);
//    private Result result = MyApplicationContextUtil.getBean(com.yanshang.watchpro.utils.Result.class);


    /**
     * 建立链接
     *
     * @param session
     * @param name
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "roomId") String roomId, @PathParam(value = "name") String name) {
        this.name = name;
        this.session = session;
        this.roomId = roomId;
        webSocket.put(name, this);
        //群发房间里用户
        Object data = userService.add(roomId, name);
        String datas = JSONObject.toJSONString(data);
        groupSending(datas,session);
        //指定发
        appointSending("currentTime",datas);
        System.out.println("【连接成功】当前连接人数为：" + webSocket.size() + "，此人为：" + name);
    }

    /**
     * 链接关闭
     */
    @OnClose
    public void onClose() {
//        for(String name : webSocket.keySet()) {
//            if (this == webSocket.get(name)) {
//                webSocket.remove(name);
//                break;
//            }
//        }
        webSocket.remove(name);//session删除
        Object data = userService.del(roomId,name);//用户删除
        if (data == "false") {
            System.out.println("【退出成功】当前连接人数为：" + webSocket.size());
            return;
        }
        groupSending(JSONObject.toJSONString(data),session);
        System.out.println("【退出成功】当前连接人数为：" + webSocket.size());
    }

    /**
     * 发生错误
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
//        System.out.println("error:");
        throwable.printStackTrace();
    }

    /**
     * 收发消息
     *
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        JSONObject obj = JSONObject.parseObject(message);
        String type = obj.getString("type");
        Integer code = obj.getInteger("code");
        String data = obj.getString("data");
        Map<String, Object> reMsg = new HashMap<>();
        if(type.equals("msg")){
            if (code==1001){
                msgService.add(roomId,name,data);
            }
        }else{
            //为视频video
            if(code==2004){
                JSONObject videoMsg = JSONObject.parseObject(data);
                String url = videoMsg.getString("msg");
                roomService.updateUrlByRoom(url,roomId);
            }else if (code==2006){
                NameSending(data);
                return;
            }
        }
//        System.out.println("【接收成功】内容为：" + message);
        groupSending(message, session);
    }

    //群发
    public void groupSending(String message, Session exIncludeSession) {
        Map<String, Set<String>> map = Result.userByRoom;
        for (String name : map.get(roomId)) {
            Session user = webSocket.get(name).session;
            synchronized(user){
                if(user.isOpen()){
                try {
                    user.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }}
        }
    }

    //随机发
    public void appointSending(String name, String message) {
        Map<String, Set<String>> map = Result.userByRoom;
        try {
                for (String s : map.get(roomId)) {
                    if (s != this.name) {
                        Result result = new Result(2005, this.name, "video");
                        webSocket.get(s).session.getBasicRemote().sendText(JSONObject.toJSONString(result));
                        return;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //指定发视频时间
    public void NameSending(String message) {
        JSONObject obj = JSONObject.parseObject(message);
        String FromName = obj.getString("name");
        String CurrentTime = obj.getString("msg");
        Map<String, String> reMsg = new HashMap<>();
        reMsg.put("msg",CurrentTime);
        System.out.print(message);
        try {
                    Result result = new Result(2006, reMsg, "video");
                    webSocket.get(FromName).session.getBasicRemote().sendText(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
