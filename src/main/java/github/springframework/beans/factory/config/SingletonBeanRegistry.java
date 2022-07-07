package github.springframework.beans.factory.config;

/**
 * 获取单例得bean
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
