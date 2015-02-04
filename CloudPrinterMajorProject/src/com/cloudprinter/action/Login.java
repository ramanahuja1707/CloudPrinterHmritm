package com.cloudprinter.action;

import com.cloudprinter.logger.CloudPrinterLogger;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login extends ActionSupport {

	String loginId;
	String mailId;
	String password;
	String loginError;
	private static String FQCN=Login.class.getName();

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

			return "success";
		else {
			setLoginError("INVALID CREDENTIALS");
			return "error";
		}

	}

	@Override
	public void validate() {
		if (getLoginId().equals("")) {
             CloudPrinterLogger.log4j(FQCN, com.cloudprinter.logger.CloudPrinterLogger.LOG.ERROR, "Invalid login Id", null);
			addFieldError("loginId", "Please enter login-id...");
			setLoginError("INVALID CREDENTIALS");
		}
		if (getMailId().equals("")) {
			CloudPrinterLogger.log4j(FQCN, com.cloudprinter.logger.CloudPrinterLogger.LOG.ERROR, "Invalid email Id", null);
			addFieldError("mailId", "Please enter mail-id...");
			setLoginError("INVALID CREDENTIALS");
		}
		if (getPassword().equals("")) {
			CloudPrinterLogger.log4j(FQCN,
					com.cloudprinter.logger.CloudPrinterLogger.LOG.ERROR,
					"Invalid password", null);
			addFieldError("password", "Please enter password...");
			setLoginError("INVALID CREDENTIALS");
		}

	}
}
