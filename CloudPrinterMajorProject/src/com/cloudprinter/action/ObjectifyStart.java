package com.cloudprinter.action;

import java.util.logging.Logger;

import com.cloudprinter.services.ObjectifyRegisterService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ObjectifyStart extends ActionSupport {
	private ObjectifyRegisterService ors;
	private static final Logger log = Logger.getLogger(ObjectifyStart.class
			.getName());

	@Override
	public String execute() throws Exception {
		ors = new ObjectifyRegisterService();
		log.info("Objectify Services Registered");
		return "success";

	}

}
