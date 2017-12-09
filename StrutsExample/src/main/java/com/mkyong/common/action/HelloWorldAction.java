package com.mkyong.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mkyong.common.form.HelloWorldForm;

public class HelloWorldAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HelloWorldForm helloWorldForm = (HelloWorldForm) form;
		helloWorldForm.setMessage("Hello World! Struts");
		// set gender in request
		request.setAttribute("var1", "male");
		request.setAttribute("var2", "female");
		//set city in form
		String[] cities = new String[] { "BBS", "BLR", "CHN" };
		helloWorldForm.setCity(cities);
		//set form in request
		request.setAttribute("helloWorldForm", helloWorldForm);
		System.out.println(helloWorldForm.getName());
		return mapping.findForward("success");
	}

}