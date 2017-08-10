package cn.xujinchun.ofounlocker.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;

import cn.xujinchun.ofounlocker.dao.IActionDao;
import cn.xujinchun.ofounlocker.pojo.Tofo;

public class WebAction {
	private static Logger log = Logger.getLogger(WebAction.class);
	
	private String bicycleid;
	private String password;
	private IActionDao actiondao;

	public String getBicycleid() {
		return bicycleid;
	}

	public void setBicycleid(String bicycleid) {
		this.bicycleid = bicycleid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IActionDao getActiondao() {
		return actiondao;
	}

	public void setActiondao(IActionDao actiondao) {
		this.actiondao = actiondao;
	}

	public String input(){
		log.info("【START】[Class]WebAction [Method]input starting......*************************");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		log.info("bicycleid----------------------->"+bicycleid);
		log.info("password----------------------->"+password);
		
		//调用查询方法查询BicycleID是否已经存在 
		Tofo ofo = this.actiondao.queryByBicycleID(bicycleid);
		
		JSONObject jsonObj = new JSONObject();

		if(ofo != null && !"".equals(ofo)){
			jsonObj.put("bicycleid", ofo.getBicycleid());
			jsonObj.put("password", ofo.getPassword());
		}else{
			int n = this.actiondao.insert(bicycleid, password);
			jsonObj.put("insertnum", n);
		}
		
		log.info(jsonObj);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(jsonObj.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
		
		
		log.info("【END】[Class]WebAction [Method]input end**************************");
		return null;	
	}
	
	public String update(){
		log.info("【START】[Class]WebAction [Method]update starting......*************************");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		log.info("bicycleid----------------------->"+bicycleid);
		log.info("password----------------------->"+password);
		
		int n = this.actiondao.update(bicycleid, password);
		
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(n);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
		
		
		log.info("【END】[Class]WebAction [Method]update end**************************");
		return null;
	}
	
	public String check(){
		log.info("【START】[Class]WebAction [Method]check starting......*************************");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		log.info("bicycleid----------------------->"+bicycleid);
		Tofo ofo = this.actiondao.queryByBicycleID(bicycleid);
				
		JSONObject jsonObj = new JSONObject();
		
		if(ofo != null && !"".equals(ofo)){
			jsonObj.put("bicycleid", ofo.getBicycleid());
			jsonObj.put("password", ofo.getPassword());
		}
		
		log.info(jsonObj);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(jsonObj.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
		
		log.info("【END】[Class]WebAction [Method]check end**************************");

		return null;
		
	}
	
}
