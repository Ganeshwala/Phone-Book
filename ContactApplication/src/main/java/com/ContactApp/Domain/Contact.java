package com.ContactApp.Domain;

public class Contact {

	private Integer contactId;// PK -key
	private Integer userId; // FK -key
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	private String contactAddress;
	private String contactRemark;


	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactRemark() {
		return contactRemark;
	}

	public void setContactRemark(String contactRemark) {
		this.contactRemark = contactRemark;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", userId=" + userId + ", contactName=" + contactName
				+ ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail + ", contactAddress="
				+ contactAddress + ", contactRemark=" + contactRemark + "]";
	}

}
