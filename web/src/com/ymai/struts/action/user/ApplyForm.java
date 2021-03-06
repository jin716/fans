/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.ymai.struts.FormUtil;
import com.ymai.struts.IllegalParameter;

/** 
 * MyEclipse Struts
 * Creation date: 06-30-2010
 * 
 * XDoclet definition:
 * @struts.form name="applyForm"
 */
public class ApplyForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** message property */
	private String message;

	/** storeName property */
	private String storeName;

	/** telephone property */
	private String telephone;

	/** address property */
	private String address;

	/** name property */
	private String name;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the message.
	 * @return String
	 */
	public String getMessage() {
		return FormUtil.escape(message);
	}

	/** 
	 * Set the message.
	 * @param message The message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** 
	 * Returns the storeName.
	 * @return String
	 */
	public String getStoreName() {
		return FormUtil.escape(storeName);
	}

	/** 
	 * Set the storeName.
	 * @param storeName The storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/** 
	 * Returns the telephone.
	 * @return String
	 */
	public String getTelephone() {
		return FormUtil.escape(telephone);
	}

	/** 
	 * Set the telephone.
	 * @param telephone The telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/** 
	 * Returns the address.
	 * @return String
	 */
	public String getAddress() {
		return FormUtil.escape(address);
	}

	/** 
	 * Set the address.
	 * @param address The address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return FormUtil.escape(name);
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}