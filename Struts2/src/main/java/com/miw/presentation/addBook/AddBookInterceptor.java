package com.miw.presentation.addBook;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.miw.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AddBookInterceptor extends AbstractInterceptor implements StrutsStatics {

	private static final long serialVersionUID = -4077390198609734426L;
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void init() {
		logger.debug("Interceptor login initialized");
		super.init();
	}

	@Override
	public void destroy() {
		logger.debug("Interceptor login destroyed");
		super.destroy();
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		logger.debug("Interceptor add book fired");
		
		ActionContext ctx = invocation.getInvocationContext();

		User user = (User) ctx.getSession().get("loginInfo");
		String uri = ctx.getName().toLowerCase();
		
		return invocation.invoke();
	}

}
