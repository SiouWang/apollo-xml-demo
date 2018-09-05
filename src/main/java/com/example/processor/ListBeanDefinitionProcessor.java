package com.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

public class ListBeanDefinitionProcessor implements BeanDefinitionRegistryPostProcessor {
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        String [] beanNames = beanDefinitionRegistry.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(">>>>>>>>>> ListBeanDefinitionProcessor.postProcessBeanDefinitionRegistry: " + beanName);
        }

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
