package com.cloudprinter.action;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import javax.mail.MessagingException;

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
	private static final Logger log = Logger
			.getLogger(Register.class.getName());

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
		String userStatus = authenticateUser.authenticateUserEmailId(
				getUserInformation().getLoginId(), getUserInformation()
						.getEmailId());
		if (userStatus.matches("not_exist")) {

			try {

				RegistrationService register = new RegistrationService();
				log.info("Registration Service Created...");
				RegistrationStatus registrationStatus = register
						.registerUser(userInformation);
				if (registrationStatus.getStatus().equals("registered")) {
					setRegistrationStatus("User Registered...");
					log.info("User Registered Successfully");
					return "success";
				} else {
					setRegistrationStatus("User Not Registered...");
					setRegistrationError(registrationStatus.getErrors().get(0));
					log.info("User Registration Error...");
					return "failure";
				}
			} catch (RegistrationException e) {
				log.info("User Registration Error due to registration exception..");
				setRegistrationError("INVALID CREDENTIALS..." + e.getMessage());
				return "failure";
			} catch (UnsupportedEncodingException e) {
				log.info("Unsupported Encoding Exception supported..");
				setRegistrationError("Unsupported Encoding Exception supported..");
				return "failure";
			} catch (MessagingException e) {
				log.info("Messaging Exception..");
				setRegistrationError("Messaging Exception..");
				return "failure";
			}catch (Exception e) {
				log.info("Exception occured while registering :"+e);
				setRegistrationError("Some Error occured , try after some time :-(");
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
			log.warning("Age should be in between 22-60..");
			addFieldError("userInformation.age",
					"Age should be in between 22-60..");
		}
		if (getUserInformation().getAlternateEmail() == null) {
			log.warning("Invalid Alternate Email-id..");
			addFieldError("userInformation.alternateEmail",
					"Invalid Email-id..");
		}
		if (getUserInformation().getContactNumber() == null) {
			log.warning("Invalid contact number..");
			addFieldError("userInformation.contactNumber",
					"Invalid contact number..");
		}
		if (getUserInformation().getEmailId() == null) {
			log.warning("Invalid Email-id..");
			addFieldError("userInformation.emailId", "Invalid Email-id..");
		}
		if (getUserInformation().getGender() == null) {
			log.warning("Please Select Gender..");
			addFieldError("userInformation.gender", "Please Select Gender..");
		}

		if (getUserInformation().getLoginId() == null) {
			log.warning("Invalid Login Id..");
			addFieldError("userInformation.loginId", "Invalid Login Id");
		}
		if (getUserInformation().getUserDesignation() == null) {
			log.warning("Invalid User Designation..");
			addFieldError("userInformation.userDesignation",
					"Invalid User Designation..");
		}
		if (getUserInformation().getUserName() == null) {
			log.warning("Username should be at least 8 characters long...");
			addFieldError("userInformation.userName",
					"Username should be at least 8 characters long...");
		}
		if (getUserInformation().getUserWorkLocation() == null) {
			log.warning("Invalid Work Place..");
			addFieldError("userInformation.userWorkLocation",
					"Invalid Work Place..");
		}
		super.validate();
	}
}
