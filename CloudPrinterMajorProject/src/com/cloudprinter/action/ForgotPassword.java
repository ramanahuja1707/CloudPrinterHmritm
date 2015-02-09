package com.cloudprinter.action;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.cloudprinter.services.AuthenticateUserService;
import com.cloudprinter.services.PasswordMailingService;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPassword extends ActionSupport {
	private String forgotPasswordStatus;

	public String getForgotPasswordStatus() {
		return forgotPasswordStatus;
	}

	public void setForgotPasswordStatus(String forgotPasswordStatus) {
		this.forgotPasswordStatus = forgotPasswordStatus;
	}

	private String emailId;
	private String LoginId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	@Override
	public String execute() {
		
		try {
			AuthenticateUserService userAuthentication = new AuthenticateUserService();
			String password = userAuthentication
					.authenticateUserEmailIdAndGetPassword(getLoginId(),
							getEmailId());
			if (!(password.equals(""))) {
				PasswordMailingService pms = new PasswordMailingService();
				if (pms.sendMail(getEmailId(), getLoginId(), password)) {
					setForgotPasswordStatus("Password Sent To Registered Email Id...:-)");
					return "forgotpassword_success";
				} else {
					setForgotPasswordStatus("Password Sending Error occured , try again...");
					return "forgotpassword_error";
				}
			} else {
				setForgotPasswordStatus("User is not registered yet , please register first..");
				return "user_not_registered";
			}
		} catch (MessagingException | UnsupportedEncodingException e) {
			setForgotPasswordStatus("Password Sending Error occured , try again...");
			return "forgotpassword_error";
		} catch (Exception e) {
			setForgotPasswordStatus("Password Sending Error occured , try again...");
			return "forgotpassword_error";
		}

	}

	@Override
	public void validate() {
		if (getEmailId().equals("")) {
			addFieldError("emailId", "Please Enter Email-Id...");
		}
		if (getLoginId().equals("")) {
			addFieldError("loginId", "Please Enter Login Id...");
		}
		super.validate();
	}
}
