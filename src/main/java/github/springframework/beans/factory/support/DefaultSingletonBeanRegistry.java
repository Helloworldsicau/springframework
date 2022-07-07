package github.springframework.beans.factory.support;

import github.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 *这个类比较简单主要是定义了一个获取单例对象的接口。
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singleObject=new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singleObject.get(beanName);
    }

    protected void addSingleObject(String beanName,Object bean){
        singleObject.put(beanName,bean);
    }
}
