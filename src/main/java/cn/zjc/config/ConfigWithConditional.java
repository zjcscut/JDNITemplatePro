package cn.zjc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @author zhangjinci
 * @version 2016/9/19 18:22
 * @function
 */
@Configuration
@Conditional(MyCondition.class)
public class ConfigWithConditional {

    @Bean
    public Serializable createSerializable() {
        System.out.println("init this bean:createSerializable()");
        return "";
    }
}
