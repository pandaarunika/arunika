package com.arunika.spring_core;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor  implements BeanPostProcessor, BeanFactoryAware {
	BeanFactory bf;
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("postProcessAfterInitialization");
		if(arg0 instanceof Employee){
			Employee e=(Employee)arg0;
			e.setName(e.getName().toUpperCase());
		}
		return arg0;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return arg0;
	}

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		bf = arg0;
	}
}
