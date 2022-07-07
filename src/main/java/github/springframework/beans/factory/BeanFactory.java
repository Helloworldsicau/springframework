package github.springframework.beans.factory;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    /**
     * 解决 多个构造函数异常
     * @param beanName
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;
}
