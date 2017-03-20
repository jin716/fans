/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.s;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.ymai.hibernate.HibernateSessionFactory;
import com.ymai.hibernate.Store;
import com.ymai.hibernate.User;
import com.ymai.struts.Page;
import com.ymai.struts.action.user.UserValidate;

/** 
 * MyEclipse Struts
 * Creation date: 05-10-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ItemListAction extends Action {
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
	 * @throws IOException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)  {
		User current = UserValidate.getUser(request);
		
		Integer storeId = Integer.valueOf(request.getParameter("store"));
		Store store = StoreFacade.getStore(storeId);
		//无此权限，退出
		if(!store.getUser().getUserId().equals(current.getUserId())){
			request.getSession().setAttribute("mess","权限不足，请先登录。");
			return mapping.findForward("login");
		}
		else{
			//有权限，进入物品列表页面
			String curPageStr = request.getParameter("page");
			String type = request.getParameter("type");
			String type_ch = null;
			if(type!=null && type.equals("up"))
				type_ch = "上架";
			if(type!=null && type.equals("down"))
				type_ch = "下架";
			//当前页数
			Integer curr = 1;
			if(curPageStr != null)curr = Integer.valueOf(curPageStr);
			//Page page = StoreFacade.getItemPage(storeId, curr,type_ch);
			request.setAttribute("type",type);
			//request.setAttribute("page", page);
			request.setAttribute("store", store);
			return mapping.findForward("itemList");
		}
	}
}