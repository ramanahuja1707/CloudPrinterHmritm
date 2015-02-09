package com.cloudprinter.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport implements SessionAware {
	private Map session;
	private String logoutStatus;

	public String getLogoutStatus() {
		return logoutStatus;
	}

	public void setLogoutStatus(String logoutStatus) {
		this.logoutStatus = logoutStatus;
	}

	@Override
	public String execute() throws Exception {
		if (session != null) {
			if (session.containsKey("loginId")) {

				session.remove("loginId");
			}
			if (session.containsKey("emailId")) {
				session.remove("emailId");
			}
			if (session.containsKey("password")) {
				session.remove("password");
			}
			session = null;
			setLogoutStatus("Logout Successfully...");
			return "logout_successfully";
		} else {
			session = null;
			setLogoutStatus("Logout Error...");
			return "logout_error";
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
}
