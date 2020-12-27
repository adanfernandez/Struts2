package com.miw.presentation.actions;

import java.util.Map;

import org.apache.catalina.valves.RemoteAddrValve;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({ @Result(name = "success", location = "counter.action", type = "redirectAction"),
	@Result(name = "login-error", location = "/index.jsp"),
	@Result(name = "captcha-error", location = "/index.jsp"),
	@Result(name = "input", location = "/index.jsp")

})
@Validations(
		requiredStrings = {
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.name", message = "You must enter a value for name"),
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.email", message = "You must enter a value for email"),
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.phone", message = "You must enter a value for phone"),
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.password", message = "You must enter a value for password"),
					@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.passwordConfirm", message = "You must enter a value for passwordConfirm") })
public class RegisterAction extends ActionSupport implements RequestAware{

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 2651261795976314789L;
	private User user = null;
	private Map<String, Object> request;

	
	@Override
	public void validate() {
		logger.debug(this.getClass());
		if(user.getName().length() == 0 && user.getName().length() > 50) {
			addFieldError("user.name", "Name field should not be emtpy and have a max length of 50 characters");
		}
		if(user.getEmail().length() == 0 && user.getEmail().length() > 50) {
			addFieldError("user.email", "Email field should not be emtpy and have a max length of 50 characters");
			}
		if(user.getPhone().length() == 0 && user.getPhone().length() > 50) {
			addFieldError("user.phone", "Phone field should not be emtpy and have a max length of 50 characters");
		}
		if(user.getPassword().length() == 0 && user.getPassword().length() > 50) {
			addFieldError("user.password", "Password field should not be emtpy and have a max length of 50 characters");
		}
		if(!(user.getPassword().equals(user.getRepeatPassword()))) {
			addFieldError("user.password", "Password field and confirmation should be equal");
		}
		super.validate();
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String execute() {
		
		return SUCCESS;
	}
	
}
