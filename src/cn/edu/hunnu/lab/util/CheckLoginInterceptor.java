package cn.edu.hunnu.lab.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class CheckLoginInterceptor implements Interceptor {

	public void destroy() {}
	public void init() {}

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		if (req.getSession().getAttribute("username") == null) {
			return "success";
		} else {
			return invocation.invoke();
		}
	}
}


