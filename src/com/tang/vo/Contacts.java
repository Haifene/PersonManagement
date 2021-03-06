package com.tang.vo;


/**
 * Contacts VO
 * @author TangXW
 *
 */
public class Contacts {
	private int contactsid;
	private int userid;
	private String name;
	private String phone;
	private String email;
	private String address;
	
	// get & set
	public int getContactsid() {
		return contactsid;
	}
	public void setContactsid(int contactsid) {
		this.contactsid = contactsid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
