/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.a;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sphx.api.SphinxException;

import com.ymai.hibernate.City;
import com.ymai.hibernate.Item;
import com.ymai.hibernate.Store;
import com.ymai.hibernate.User;
import com.ymai.struts.FormUtil;
import com.ymai.struts.Page;
import com.ymai.struts.action.ActionFacade;
import com.ymai.struts.action.SearchUtil;
import com.ymai.struts.action.order.OrderFacade;
import com.ymai.struts.action.user.UserValidate;

/** 
 * MyEclipse Struts
 * Creation date: 06-04-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class WelcomeAction extends Action {
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
		String action = request.getParameter("action");
		if(action == null){
			return welcome(mapping, form,request, response);
		}
		if(action.equals("blockAdd")){
			return blockAdd(mapping, form,request, response);
		}
		if(action.equals("blockEdit")){
			return blockEdit(mapping, form,request, response);
		}
		if(action.equals("storeList")){
			return storeList(mapping, form,request, response);
		}
		if(action.equals("storeEdit")){
			return storeEdit(mapping, form,request, response);
		}
		if(action.equals("storeAdd")){
			return storeAdd(mapping, form,request, response);
		}
		if(action.equals("menuUp")){
			return menuUp(mapping, form,request, response);
		}
		return null;
	}
	
	ActionForward welcome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		User user = UserValidate.getUser(request);
		if(user == null||user.getUserIsAdmin()!=true)
			return mapping.findForward("ulogin");
		String url = request.getParameter("url");
		if(url == null) url = "storeList";
		request.setAttribute("url", url);
		return mapping.findForward("welcome");
	}
	
	ActionForward blockAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		User user = UserValidate.getUser(request);
		if(user == null||user.getUserIsAdmin()!=true)
			return mapping.findForward("ulogin");
		String url = request.getParameter("url");
		List city_list = AdminFacade.getAllCity();
		FormUtil.setFromId(request, "BE_uitlValue");
		request.getSession().setAttribute("city_list", city_list);
		return mapping.findForward("blockAdd");
	}
	
	ActionForward blockEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		User user = UserValidate.getUser(request);
		if(user == null||user.getUserIsAdmin()!=true)
			return mapping.findForward("ulogin");
		List city_list = AdminFacade.getAllCity();
		FormUtil.setFromId(request, "BE_uitlValue");
		request.getSession().setAttribute("city_list", city_list);
		return mapping.findForward("blockEdit");
	}
	
	ActionForward storeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		User user = UserValidate.getUser(request);
		if(user == null||user.getUserIsAdmin()!=true)
			return mapping.findForward("ulogin");
		String key  = request.getParameter("KeyWord");
		String real_key = null;
		Integer pageNum = 1;
		String page = request.getParameter("page");
		if(page!=null)pageNum = Integer.valueOf(page);
		if(key == null||key.trim().length() == 0) real_key = null;
		else
			try {
				real_key =URLDecoder.decode(key, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//.replaceAll("\\+", " ");
		List res = null;
		request.setAttribute("key", key);
		request.setAttribute("real_key", real_key);
		try {
			if(real_key!=null)
				res = UserAdminFacade.selectLikeStore(real_key);
			request.setAttribute("store_list", res);
		} catch (Exception e) {
			request.setAttribute("store_list", null);
			e.printStackTrace();
		}
		return mapping.findForward("storeList");
	}
	
	ActionForward storeEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String storeIdStr = request.getParameter("store");
		Integer storeId = null;
		if(storeIdStr != null){
			storeId = Integer.valueOf(storeIdStr);
			Store store = (Store) ActionFacade.get(Store.class, storeId);
			request.setAttribute("store", store);
		}
		List city_list = AdminFacade.getAllCity();
		request.setAttribute("city_list", city_list);
		return mapping.findForward("storeEdit");
	}
	
	ActionForward storeAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		List city_list = AdminFacade.getAllCity();
		request.setAttribute("city_list", city_list);
		return mapping.findForward("storeAdd");
	}
	
	ActionForward menuUp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String storeIdStr = request.getParameter("store");
		Integer storeId = null;
		if(storeIdStr != null){
			storeId = Integer.valueOf(storeIdStr);
			Store store = (Store) ActionFacade.get(Store.class, storeId);
			request.setAttribute("store", store);
		}
		return mapping.findForward("menuUp");
	}
	

}