package com.cloudprinter.action;

import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login extends ActionSupport {
	private static final Logger log = Logger.getLogger(Login.class.getName());
	private String loginId;
	private String mailId;
	private String password;
	private String loginError;

	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		if (getLoginId().equals("hello") && getPassword().equals("123"))
		{
		log.info("Login Successfully...");
			return "success";
		}
		else {
			setLoginError("INVALID CREDENTIALS");
			return "error";
		}

	}

	@Override
	public void validate() {
		if (getLoginId().equals("")) {
			log.warning("Invalid id...");
			addFieldError("loginId", "Please enter login-id...");
			setLoginError("INVALID CREDENTIALS");
		}
		if (getMailId().equals("")) {
			log.warning("invalid id...");
			addFieldError("mailId", "Please enter mail-id...");
			setLoginError("INVALID CREDENTIALS");
		}
		if (getPassword().equals("")) {
			log.warning("invalid id...");
			addFieldError("password", "Please enter password...");
			setLoginError("INVALID CREDENTIALS");
		}

	}
}
