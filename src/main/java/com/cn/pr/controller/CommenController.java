/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.cn.pr.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.pr.pojo.JsonMessageBean;
import com.cn.pr.service.impl.UserService;


@Controller
@RequestMapping("")
public class CommenController{
	
	@Autowired private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(CommenController.class);

	@RequestMapping(value="/comm/test.action",method = RequestMethod.POST)
	public @ResponseBody JsonMessageBean jump(HttpSession session,HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, Object> paraMap) throws Exception{
		JsonMessageBean jmb = new JsonMessageBean();
		String paraString =JSONObject.toJSONString(paraMap);
		JSONObject obj = JSONObject.parseObject(paraString);
		logger.info("请求参数:"+obj.toJSONString());
		//TODO System.out.println(obj.toString());
		String actionname = obj.getString("ACTION_NAME");
//		JSONObject info = JSONObject.parseObject(obj.getString("ACTION_INFO"));
		if("LOGIN".equals(actionname)){
			jmb = userService.login(obj);
		}else if("REGIST".equals(actionname)){
			jmb = userService.regist(obj);
		}
		return jmb;
	}
}