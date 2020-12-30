package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name = "success", location = "/index.jsp")
	}
)

public class LogoutAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = -3854762737466390371L;
	private Map<String, Object> session = null;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public String execute() {
		session.clear();
		return SUCCESS;
	}
}
