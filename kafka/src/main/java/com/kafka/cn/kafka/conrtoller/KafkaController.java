package com.kafka.cn.kafka.conrtoller;

        import com.alibaba.fastjson.JSON;
        import org.apache.kafka.clients.producer.ProducerRecord;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.kafka.core.KafkaTemplate;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.HashMap;
        import java.util.Map;

/**
 * @author cpf07
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @RequestMapping("/sendM")
    public void sendM(){

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("wd","王岱");
        map.put("id","1");

        kafkaTemplate.send("param", JSON.toJSONString(map));
        System.out.println("完成！");
    }
}
