/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.a;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.ymai.hibernate.User;
import com.ymai.struts.action.user.UserValidate;

/** 
 * MyEclipse Struts
 * Creation date: 07-12-2010
 * 
 * XDoclet definition:
 * @struts.action path="/user/a/menuUp" name="menuUpForm" input="/user/a/menuUp_frame.jsp" scope="request"
 */
public class ImageUpAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MenuUpForm menuUpForm = (MenuUpForm) form;// TODO Auto-generated method stub
		User user = UserValidate.getUser(request);
		if(user == null||user.getUserIsAdmin()!=true)
			return mapping.findForward("login");
		Integer storeId = menuUpForm.getStoreId();
		request.setAttribute("storeId", storeId);
		FormFile file = menuUpForm.getExcel();
		if(file==null||file.getFileName()==null||file.getFileName().trim().length()==0)	return mapping.findForward("error");

		try {
			UserAdminFacade.saveImage(storeId, file,request);
			return mapping.findForward("ok");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
}