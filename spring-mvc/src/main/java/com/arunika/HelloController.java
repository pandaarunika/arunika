package com.arunika;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController /*implements Controller *//*implements BeanFactoryAware */{
	//BeanFactory bf;
	/*@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.bf=arg0;
	}*/

	/*@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String messagevalue="Hello sdjhfjdh";
		System.out.println("1i am here");
		return new ModelAndView("hello","messageName",messagevalue);
	}*/
	@RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        System.out.println("1i am here");
        return new ModelAndView("hello", "messageName", message);  
    } 
	@RequestMapping("/")  
    public ModelAndView helloWorld1() {  
        String message = "HELL02";  
        System.out.println("1i am here");
        return new ModelAndView("hello", "message", message);  
    } 
}
