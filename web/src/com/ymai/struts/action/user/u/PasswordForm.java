/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.u;

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
 * Creation date: 07-03-2010
 * 
 * XDoclet definition:
 * @struts.form name="passwordForm"
 */
public class PasswordForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** new_p property */
	private String new_p;

	/** vcode property */
	private String vcode;

	/** old_p property */
	private String old_p;

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
	 * Returns the new_p.
	 * @return String
	 */
	public String getNew_p() {
		return new_p;
	}

	/** 
	 * Set the new_p.
	 * @param new_p The new_p to set
	 */
	public void setNew_p(String new_p) {
		this.new_p = new_p;
	}

	/** 
	 * Returns the vcode.
	 * @return String
	 */
	public String getVcode() {
		return vcode;
	}

	/** 
	 * Set the vcode.
	 * @param vcode The vcode to set
	 */
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	/** 
	 * Returns the old_p.
	 * @return String
	 */
	public String getOld_p() {
		return old_p;
	}

	/** 
	 * Set the old_p.
	 * @param old_p The old_p to set
	 */
	public void setOld_p(String old_p) {
		this.old_p = old_p;
	}
}