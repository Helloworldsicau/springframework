package github.springframework.beans.factory.config;

public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanDefinition) {
        this.beanClass = beanDefinition;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
