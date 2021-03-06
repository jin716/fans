/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.s;

import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ymai.hibernate.HibernateSessionFactory;
import com.ymai.hibernate.Store;
import com.ymai.hibernate.User;
import com.ymai.struts.FormUtil;
import com.ymai.struts.action.user.UserValidate;

/** 
 * MyEclipse Struts
 * Creation date: 05-11-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class StoreEditCommitAction extends Action {
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
		Integer id = Integer.valueOf(request.getParameter("storeId"));
		long mobile_l = Long.valueOf(request.getParameter("storeMobile"));
		BigInteger mobile = BigInteger.valueOf(mobile_l);
		String brief = FormUtil.escape(request.getParameter("storeBrief"));
		Boolean storeSendSMS = Boolean.valueOf(request.getParameter("smsSend"));
		Integer s_hour = Integer.valueOf(request.getParameter("s_hour"));
		Integer s_min = Integer.valueOf(request.getParameter("s_min"));
		Date s_time = new Date();
		s_time.setHours(s_hour);
		s_time.setMinutes(s_min);
		
		Integer e_hour = Integer.valueOf(request.getParameter("e_hour"));
		Integer e_min = Integer.valueOf(request.getParameter("e_min"));
		Date e_time = new Date();
		e_time.setHours(e_hour);
		e_time.setMinutes(e_min);
		
		Double storeSendCost = Double.valueOf(request.getParameter("storeSendCost"));
		Double storeLowCost = Double.valueOf(request.getParameter("storeLowCost"));
		Session session =  HibernateSessionFactory.getSession();
		Transaction tran = null;
		try{
			tran = session.beginTransaction();
			tran.begin();
			Store store = (Store) session.load(Store.class, id);
			store.setStoreBrief(brief);
			store.setStoreMobile(mobile);
			store.setStoreStartTime(s_time);
			store.setStoreEndTime(e_time);
			System.out.println(store.getStoreSendSMS());
			System.out.println(storeSendSMS);
			store.setStoreSendSMS(storeSendSMS);
			System.out.println(store.getStoreSendSMS());

			store.setStoreSendCost(storeSendCost);
			store.setStoreLowCost(storeLowCost);
			session.update(store);
			tran.commit();
			response.sendRedirect("welcome.do?action=storeList");
		}catch(Exception e){
			return mapping.findForward("error");
		}finally{
			if(session.isOpen())session.close();
		}
		return null;
	}
}