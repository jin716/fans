/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ymai.hibernate.HibernateSessionFactory;
import com.ymai.hibernate.User;

/** 
 * MyEclipse Struts
 * Creation date: 05-10-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class PasswordAction extends Action {
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
		String old = request.getParameter("old_p");
		String new_p = request.getParameter("new_p");
		String vCode = request.getParameter("vcode");
		User current = UserValidate.getUser(request);
		//检查用户登录状态
		if(current == null){
			request.getSession().setAttribute("mess","请先登录。");
			return mapping.findForward("login");
		}
		if(!vCode.equals(request.getSession().getAttribute("rand"))){
			request.getSession().setAttribute("mess", "验证码输入错误！");
			return mapping.findForward("error");
		}
		if(!current.getUserPassword().equals(old)){
			request.getSession().setAttribute("mess", "旧密码输入错误！");
			return mapping.findForward("error");
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = null;
		try{
			tran = session.beginTransaction();
			tran.begin();
			current = (User) 
			session.load(User.class, current.getUserId());
			current.setUserPassword(new_p);
			tran.commit();
			session.close();
		}catch(Exception e){
			tran.rollback();
			session.close();
			request.getSession().setAttribute("mess", "修改失败！");
			return mapping.findForward("error");
		}
		UserValidate.quite(request,response);
		return mapping.findForward("ok");
	}
}