package com.cloudprinter.action;

import com.cloudprinter.dto.UserLoginInfo;
import com.cloudprinter.services.ObjectifyRegisterService;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotLoginId extends ActionSupport {
	private String forgotLoginIdStatus;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getForgotLoginIdStatus() {
		return forgotLoginIdStatus;
	}

	public void setForgotLoginIdStatus(String forgotLoginIdStatus) {
		this.forgotLoginIdStatus = forgotLoginIdStatus;
	}

	@Override
	public String execute() throws Exception {
		Objectify ob = ObjectifyRegisterService.registerService();
		Query<UserLoginInfo> userList = (Query<UserLoginInfo>) ob.query(
				UserLoginInfo.class).filter("emailId", getEmailId());
		setForgotLoginIdStatus("Sorry , Your Email Id is not registered...:-( , please register first...");
		if (userList.list().size() > 0) {
			for (UserLoginInfo u : userList) {
				if (u.getEmailId().equals(getEmailId())) {
					setForgotLoginIdStatus("Your Username is :"
							+ u.getLoginId());
					break;
				}
			}
		}
		return "forgotloginid_success";
	}

	@Override
	public void validate() {
		if (getEmailId().equals("")) {
			addFieldError("emailId", "Enter Valid Email Id...:-(");
		}
		super.validate();
	}
}
