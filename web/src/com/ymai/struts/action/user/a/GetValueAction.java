/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.ymai.struts.action.user.a;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ymai.hibernate.Block;
import com.ymai.hibernate.Position;
import com.ymai.tools.Json;

/** 
 * MyEclipse Struts
 * Creation date: 06-11-2010
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class GetValueAction extends Action {
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
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String type = request.getParameter("type");
		if(type==null){return null;}
		if(type.equals("areaListOfCity")){
			String cid_str = request.getParameter("city");
			Integer cityId = null;
			if(cid_str!=null){
				try{
					cityId = Integer.valueOf(cid_str);
				}catch(NumberFormatException e){
					return null;
				}	
			}
			List list = AdminFacade.getAreas(cityId);
			String html = Json.toJson(list);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(html);
			return null;
		}
		if(type.equals("blockListInArea")){
			try{
				String areaId_str = request.getParameter("area");
				Integer areaId = Integer.valueOf(areaId_str);
				List list = AdminFacade.getBlocksInArea(areaId);
				String json = Json.toJson(list);
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(json);
				return null;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		if(type.equals("block")){
			try{
				String blockId_str = request.getParameter("block");
				Integer blockId = Integer.valueOf(blockId_str);
				Block block = AdminFacade.getBlock(blockId);
				String json = Json.toJson(block);
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(json);
				return null;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		if(type.equals("blocks")){
			try{
				String areaId_str = request.getParameter("area");
				String fl = request.getParameter("fl");
				Integer areaId = Integer.valueOf(areaId_str);
				List list = AdminFacade.getBlocksInArea(areaId, fl);
				String json = Json.toJson(list);
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(json);
				return null;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}