/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ymai.hibernate.Store;
import com.ymai.struts.action.ActionFacade;

/** 
 * MyEclipse Struts
 * Creation date: 07-12-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class NoOpenAction extends Action {
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
		Store store = (Store) ActionFacade.get(Store.class,storeId);
		request.setAttribute("tele", store.getStoreMobile());
		request.setAttribute("name", store.getStoreName());
		return mapping.findForward("show");
	}
}