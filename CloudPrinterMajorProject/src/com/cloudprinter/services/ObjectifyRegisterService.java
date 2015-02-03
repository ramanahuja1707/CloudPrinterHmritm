package com.cloudprinter.services;

import com.cloudprinter.dto.UserInfo;
import com.cloudprinter.dto.UserLoginInfo;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifyRegisterService {

	static {
		ObjectifyService.register(UserInfo.class);
		ObjectifyService.register(UserLoginInfo.class);
	}

	public static Objectify registerService() {
		return ObjectifyService.begin();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}

}
