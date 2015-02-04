package com.cloudprinter.action;

import com.cloudprinter.dto.RegistrationStatus;
import com.cloudprinter.dto.UserInfo;
import com.cloudprinter.exceptions.RegistrationException;
import com.cloudprinter.services.AuthenticateUserService;
import com.cloudprinter.services.RegistrationService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Register extends ActionSupport {
	private String registrationError;
	private UserInfo userInformation = new UserInfo();
	private String registrationStatus;

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public String getRegistrationError() {
		return registrationError;
	}

	public void setRegistrationError(String registrationError) {
		this.registrationError = registrationError;
	}

	public UserInfo getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInfo userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String execute() {
		AuthenticateUserService authenticateUser = new AuthenticateUserService();
		String userStatus = authenticateUser.authenticateUser(
				getUserInformation().getLoginId(), getUserInformation()
						.getEmailId());
		if (userStatus.matches("not_exist")) {
			try {
				RegistrationService register = new RegistrationService();
				RegistrationStatus registrationStatus = register
						.registerUser(userInformation);
				if (registrationStatus.getStatus().equals("registered")) {
					setRegistrationStatus("User Registered...");
					return "success";
				} else {
					setRegistrationStatus("User Not Registered...");
					setRegistrationError(registrationStatus.getErrors().get(0));
					return "failure";
				}
			} catch (RegistrationException e) {
				setRegistrationError("INVALID CREDENTIALS..." + e.getMessage());
				return "failure";
			} catch (Exception e) {
				setRegistrationError("INVALID CREDENTIALS...");
				return "failure";

			}

		} else {
			setRegistrationError("USER ALREADY EXIST WITH CORRESPONDING EMAIL-ID...");
			return "user_exist";
		}
	}

	@Override
	public void validate() {
		if (getUserInformation().getAge() == null) {
			addFieldError("userInformation.age",
					"Age should be in between 22-60..");
		}
		if (getUserInformation().getAlternateEmail() == null) {

			addFieldError("userInformation.alternateEmail",
					"Invalid Email-id..");
		}
		if (getUserInformation().getContactNumber() == null) {
			addFieldError("userInformation.contactNumber",
					"Invalid contact number..");
		}
		if (getUserInformation().getEmailId() == null) {
			addFieldError("userInformation.emailId", "Invalid Email-id..");
		}
		if (getUserInformation().getGender() == null) {
			addFieldError("userInformation.gender", "Please Select Gender..");
		}

		if (getUserInformation().getLoginId() == null) {
			addFieldError("userInformation.loginId", "Invalid Login Id");
		}
		if (getUserInformation().getUserDesignation() == null) {
			addFieldError("userInformation.userDesignation",
					"Invalid User Designation..");
		}
		if (getUserInformation().getUserName() == null) {
			addFieldError("userInformation.userName",
					"Username should be at least 8 characters long...");
		}
		if (getUserInformation().getUserWorkLocation() == null) {
			addFieldError("userInformation.userWorkLocation",
					"Invalid Work Place..");
		}
		super.validate();
	}
}
