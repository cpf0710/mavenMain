package com.kafka.cn.kafka.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class UserLog {
    private String username;
    private String userid;
    private String state;

}
