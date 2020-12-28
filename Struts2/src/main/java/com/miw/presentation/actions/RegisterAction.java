package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.User;
import com.miw.presentation.user.UserManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({
		@Result(name = "success", location = "/index.jsp"),
		@Result(name = "error", location = "/WEB-INF/content/register-form.jsp"),
		@Result(name = "input", location = "/WEB-INF/content/register-form.jsp")
})

@Validations(requiredStrings = {
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.username", message = "You must enter a value for username"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.password", message = "You must enter a value for password"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.repeatPassword", message = "You must enter a value for the confirmation of the password") })


public class RegisterAction extends ActionSupport implements RequestAware {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 2651261795976314789L;
	private User user = null;
	private Map<String, Object> request;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void validate() {
		logger.debug("validating RegisterAction");
		if (user.getUsername().length() > 150) {
			addFieldError("user.username", "Username field should not be emtpy and have a max length of 150 characters");
		}
		if (user.getPhone().length() > 30) {
			addFieldError("user.phone", "Phone field should not be emtpy and have a max length of 30 characters");
		}
		if (user.getAge() > 200) {
			addFieldError("user.age", "Age field should not be greater than 200");
		}
		if (user.getPassword().length() > 100) {
			addFieldError("user.password",
					"Password field should not be emtpy and have a max length of 100 characters");
		}
		if (!(user.getPassword().equals(user.getRepeatPassword()))) {
			addFieldError("user.repeatPassword", "Password field and its confirmation should be equal");
		}
		super.validate();
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public String execute() {
		logger.debug("Execute RegisterAction");
		UserManagerServiceHelper helper = new UserManagerServiceHelper();
		System.out.println("Creado helper");
		User u = helper.getUserByUsername(user.getUsername());
		if (u != null) {
			helper.saveUser(user);
			return SUCCESS;
		}
		// Para comprobar redirecciones ponemos el return SUCCESS. 			¡¡QUITARLO!!
		//return ERROR;
		return SUCCESS;
	}

}
