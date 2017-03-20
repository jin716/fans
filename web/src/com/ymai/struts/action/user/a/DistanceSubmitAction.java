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
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ymai.hibernate.Area;
import com.ymai.hibernate.HibernateSessionFactory;
import com.ymai.hibernate.Store;
import com.ymai.struts.action.user.UserValidate;
import com.ymai.struts.action.user.s.BlockEditSubmitForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-13-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class DistanceSubmitAction extends Action {
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
		
		try {
			Double distance = Double.valueOf(request.getParameter("distance"));
			Integer storeId = Integer.valueOf(request.getParameter("storeId"));
			UserAdminFacade.changeDistance(distance, storeId);
			request.setAttribute("storeId", storeId);
			return mapping.findForward("ok");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
}