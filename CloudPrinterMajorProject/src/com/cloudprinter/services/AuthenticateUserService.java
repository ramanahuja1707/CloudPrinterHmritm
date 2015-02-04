package com.cloudprinter.services;

import com.cloudprinter.dto.UserLoginInfo;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;

public class AuthenticateUserService {
	private String status = "not_exist";

	public String authenticateUser(String loginId, String emailId) {
		Objectify ob = ObjectifyRegisterService.registerService();
		Query<UserLoginInfo> userList = (Query<UserLoginInfo>) ob.query(
				UserLoginInfo.class).filter("emailId", emailId);
		if (userList.list().size() > 0) {
			for (UserLoginInfo u : userList) {
				if (u.getEmailId().equals(emailId)
						|| u.getLoginId().equals(loginId)) {
					status = "exist";
					break;
				}
			}
		}
		return status;
	}
}
