package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.User;
import com.miw.presentation.user.UserManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({ @Result(name = "success", location = "/index.jsp"),
		@Result(name = "error", location = "/WEB-INF/content/register-form.jsp"),
		@Result(name = "input", location = "/WEB-INF/content/register-form.jsp") })

@Validations(requiredStrings = {
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "registerInfo.username", message = "You must enter a value for username"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "registerInfo.password", message = "You must enter a value for password"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "registerInfo.repeatPassword", message = "You must enter a value for the confirmation of the password") }, regexFields = {
				@RegexFieldValidator(type = ValidatorType.SIMPLE, fieldName = "registerInfo.phone", regex = "[9|6|7][0-9]{8}", message = "You must enter a correct mobile phone") })

public class RegisterAction extends ActionSupport implements RequestAware {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 2651261795976314789L;
	private User registerInfo = null;
	private Map<String, Object> request;

	public User getRegisterInfo() {
		return registerInfo;
	}

	public void setRegisterInfo(User registerInfo) {
		this.registerInfo = registerInfo;
	}

	@Override
	public void validate() {
		logger.debug("validating RegisterAction");
		if (registerInfo.getUsername().length() > 150) {
			addFieldError("registerInfo.username",
					"Username field should not be emtpy and have a max length of 150 characters");
		}
		if (registerInfo.getPhone().length() > 30) {
			addFieldError("registerInfo.phone",
					"Phone field should not be emtpy and have a max length of 30 characters");
		}
		if (registerInfo.getAge() > 200) {
			addFieldError("registerInfo.age", "Age field should not be greater than 200");
		}
		if (registerInfo.getPassword().length() > 100 || registerInfo.getPassword().length() < 5) {
			addFieldError("registerInfo.password",
					"Password field should have a min length of 5 characters and a max length of 100");
		}
		if (!(registerInfo.getPassword().equals(registerInfo.getRepeatPassword()))) {
			addFieldError("registerInfo.repeatPassword", "Password field and its confirmation should be equal");
		}
		super.validate();
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		logger.debug("Execute RegisterAction");
		UserManagerServiceHelper helper = new UserManagerServiceHelper();
		boolean registro = helper.registerUser(registerInfo);
		if (registro) {
			logger.debug("Register completed");
			return SUCCESS;
		}
		logger.debug("Register failed");
		request.put("userExists", "User already exists");
		return ERROR;
	}

}
