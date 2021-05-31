package com.kafka.cn.kafka.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class UserLogConsumer {
    @KafkaListener(topics = {"user-log"})
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            System.out.println("消费消息:"+message);
        }
    }
    @KafkaListener(topics = {"param"})
    public void  consumer2(ConsumerRecord<?,?> consumerRecord){
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            //得到Optional实例中的值
            Map<String,Object> message=JSON.parseObject((String) kafkaMessage.get());
           // Map<String,Object> message = (Map<String, Object>) kafkaMessage.get();
            System.out.println("1:"+message.get("wd"));
           System.out.println("2:"+message.get("id"));
        }
    }
}
