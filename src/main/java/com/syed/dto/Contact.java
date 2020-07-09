package com.syed.dto;

import java.util.Date;

public class Contact {
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createdDate;
	private Date updatedDate;
	
	public Contact() {
		super();
	}

	public Contact(String contactName, String contactEmail, Long contactNumber) {
		super();
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
	}

	public Integer getContactId() {
		return contactId;
	}
	
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactNumber=" + contactNumber + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
}
