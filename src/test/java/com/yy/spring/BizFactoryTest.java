package com.yy.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author chenyiqin02
 * @date 2020/03/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_spring.xml"})
@Component
public class BizFactoryTest implements ApplicationContextAware {
    @Resource(name = "bizFactory")
    private BizFactory bizFactory;

    @Resource
    private ApplicationContext applicationContextByAnnotation;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BizFactoryTest.applicationContext = applicationContext;
    }

    @Test
    public void injectTest() {
        System.out.println(bizFactory);
        System.out.println(applicationContextByAnnotation.getBean("bizFactory"));
        System.out.println(applicationContext.getBean("bizFactory"));
        applicationContextByAnnotation.getBeansOfType(AbstractGeneralBiz.class)
                .forEach((s, abstractGeneralBiz) -> System.out.println(s + " " + abstractGeneralBiz));

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext_spring.xml");
        System.out.println(classPathXmlApplicationContext.getBean("bizFactory"));
        System.out.println(applicationContextByAnnotation.getBean("bizFactory"));
        System.out.println(applicationContext.getBean("bizFactory"));
        classPathXmlApplicationContext.getBeansOfType(AbstractGeneralBiz.class)
                .forEach((s, abstractGeneralBiz) -> System.out.println(s + " " + abstractGeneralBiz));
    }

}