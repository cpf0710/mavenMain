package com.kafka.cn.kafka.producer;

import com.alibaba.fastjson.JSON;
import com.kafka.cn.kafka.bo.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserLogProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    public  void sendLog(String userid){
        UserLog userLog=new UserLog();
        userLog.setUsername("jhp");
        userLog.setUserid(userid);
        userLog.setState("0");
        System.out.println("发送用户日志数据："+userLog);
        kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
    }
}
