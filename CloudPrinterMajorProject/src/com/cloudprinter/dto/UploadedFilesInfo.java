package com.cloudprinter.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UploadedFilesInfo {
	@Id
	String fileId; // filename+date
	String loginId; // foreign key
	String fileName;
	String fileSize;
	@Temporal(TemporalType.DATE)
	Date dateOfUploading;
	String ipAddressOfHost;
	String uploadStatus;
	String UploadError;
	String fileType;
}
