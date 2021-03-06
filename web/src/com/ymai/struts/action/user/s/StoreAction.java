/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.s;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.ymai.hibernate.HibernateSessionFactory;
import com.ymai.hibernate.Store;
import com.ymai.hibernate.User;
import com.ymai.struts.Page;
import com.ymai.struts.action.user.UserValidate;

/** 
 * MyEclipse Struts
 * Creation date: 05-11-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class StoreAction extends Action {
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
		Integer storeId = Integer.valueOf(request.getParameter("store"));
		Store store = StoreFacade.getStore(storeId);
		request.setAttribute("store", store);
		return mapping.findForward("detail");
	}
}