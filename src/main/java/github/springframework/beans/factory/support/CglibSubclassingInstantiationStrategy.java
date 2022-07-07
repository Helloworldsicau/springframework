package github.springframework.beans.factory.support;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import github.springframework.beans.factory.BeansException;
import github.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new Callback() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (constructor == null)
            return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
