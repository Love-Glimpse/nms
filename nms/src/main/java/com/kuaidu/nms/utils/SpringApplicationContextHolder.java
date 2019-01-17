package com.kuaidu.nms.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
/**获取Spring ApplicationContext 工具*/
public class SpringApplicationContextHolder implements ApplicationContextAware {
         private static ApplicationContext applicationContext; // Spring应用上下文环境
         /**
          * 实现了ApplicationContextAware 接口，必须实现该方法；
          *通过传递applicationContext参数初始化成员变量applicationContext
          */
         public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
               SpringApplicationContextHolder.applicationContext = applicationContext;
         }
         /**获取applicationContext*/
         public static ApplicationContext getApplicationContext() {
                return applicationContext;
         }

        /**通过beanName获取实体类*/
		public static Object getBean(String name) throws BeansException { 
              return applicationContext==null?null:applicationContext.getBean(name);
        }
}