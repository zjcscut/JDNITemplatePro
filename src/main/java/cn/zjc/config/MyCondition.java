package cn.zjc.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhangjinci
 * @version 2016/9/19 18:21
 * @function
 */
public class MyCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //如果设置为true,ConfigWithConditional会在容器初始化的时候就加入配置中
//        return true;
        return false;
    }

}
