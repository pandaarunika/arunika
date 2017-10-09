package com.mkyong.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mkyong.common.form.HelloWorldForm;

public class HelloWorldAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HelloWorldForm helloWorldForm = (HelloWorldForm) form;
		helloWorldForm.setMessage("Hello World! Struts");
		String [] cities = new String [] {"BBS","BLR","CHN"};
		helloWorldForm.setCity(cities);
		/*request.setAttribute("city", helloWorldForm.getCity());
		request.setAttribute("var", "Hello World! Struts");
		request.setAttribute("name", helloWorldForm.getName());
		request.setAttribute("gender",helloWorldForm.getGender());
		request.setAttribute("indian",helloWorldForm.getIndian());
		request.setAttribute("city", helloWorldForm.getCity());*/
		request.setAttribute("helloWorldForm", helloWorldForm);
		return mapping.findForward("success");
	}
	
}