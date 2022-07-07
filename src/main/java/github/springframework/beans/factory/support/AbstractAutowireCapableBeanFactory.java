package github.springframework.beans.factory.support;

import github.springframework.beans.factory.BeansException;
import github.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {

        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleObject(beanName, bean);

        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Constructor constructor = null;

        Constructor[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                constructor = declaredConstructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructor, args);

    }

    ;
}
