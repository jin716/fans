/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.a;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/** 
 * MyEclipse Struts
 * Creation date: 07-12-2010
 * 
 * XDoclet definition:
 * @struts.form name="menuUpForm"
 */
public class MenuUpForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** excel property */
	private FormFile excel;

	/** storeId property */
	private Integer storeId;

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
	 * Returns the excel.
	 * @return FormFile
	 */
	public FormFile getExcel() {
		return excel;
	}

	/** 
	 * Set the excel.
	 * @param excel The excel to set
	 */
	public void setExcel(FormFile excel) {
		this.excel = excel;
	}

	/** 
	 * Returns the storeId.
	 * @return Integer
	 */
	public Integer getStoreId() {
		return storeId;
	}

	/** 
	 * Set the storeId.
	 * @param storeId The storeId to set
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
}