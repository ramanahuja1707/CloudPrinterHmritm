package com.cloudprinter.action;

import com.cloudprinter.logger.CloudPrinterLogger;
import com.cloudprinter.services.ObjectifyRegisterService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ObjectifyStart extends ActionSupport {
	private ObjectifyRegisterService ors;

	@Override
	public String execute() throws Exception {
		ors = new ObjectifyRegisterService();

		return "success";

	}

}
