/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.order;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 06-26-2010
 * 
 * XDoclet definition:
 * @struts.form name="comntForm"
 */
public class AddComntForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** detail property */
	private String detail;
	private Integer store;
	private String vcode;
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
		// TODO Auto-generated method stub
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
	 * Returns the detail.
	 * @return String
	 */
	public String getDetail() {
		return detail;
	}

	/** 
	 * Set the detail.
	 * @param detail The detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Integer getStore(){
		return this.store;
	}
	
	public void setStore(Integer storeId){
		this.store = storeId;
	}
	
	public String getVcode(){
		return this.vcode;
	}
	
	public void setVcode(String vcode){
		this.vcode = vcode;
	}
}