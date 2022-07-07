package github.springframework.beans.factory.support;


import github.springframework.beans.factory.BeanFactory;
import github.springframework.beans.factory.BeansException;
import github.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {

        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object creatBean = creatBean(beanName, beanDefinition);
        return creatBean;
    }



    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 老板创建bean 带构造函数得bean实例化会失败
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition,Object...args) throws BeansException;
}
