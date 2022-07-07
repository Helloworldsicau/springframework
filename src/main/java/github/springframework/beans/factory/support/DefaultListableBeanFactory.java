package github.springframework.beans.factory.support;

import github.springframework.beans.factory.BeansException;
import github.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> definitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        definitionMap.put(beanName, beanDefinition);
    }


    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return null;
    }
}
