package github.springframework.beans.factory.support;

import github.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
