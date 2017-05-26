package com.cn.pr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utils.MD5;
import utils.validateObj;

import com.alibaba.fastjson.JSONObject;
import com.cn.pr.dao.UserDao;
import com.cn.pr.pojo.JsonMessageBean;
import com.cn.pr.pojo.User;


@Component//将UserDao类注入到bean里面 
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired //通过名称注入到bean里面
	private UserDao userDao;
	
	public JsonMessageBean slectCount(JSONObject jsonObject) throws Exception{
		JsonMessageBean bean = new JsonMessageBean();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int count = userDao.selectCount();
		resultMap.put("data", count);
		bean.setACTION_INFO(resultMap);
		return bean;
	}
	
	/**
	 * 用户是否可以登录
	 * boolean
	 * 
	 */
	public JsonMessageBean login(JSONObject obj) throws Exception{
		logger.info("验证用户名和密码：：："+obj.toString());
		JsonMessageBean bean = new JsonMessageBean();
		Map<String , Object> resultMap = new HashMap<String, Object>();
		User user = new User();
		
		if(validateObj.isNotEmpty((obj.getString("password"))) || 
				validateObj.isNotEmpty(obj.getString("loginName"))){
			user.setLoginName(obj.getString("loginName"));
			String oldPassWord = MD5.getMD5Str(obj.getString("password"));
			List<User> dataList = userDao.getLogin(user);
			String passWord = null;
			if(dataList!=null && dataList.size()>0){
				for(User userObj:dataList){
					passWord = userObj.getPassword();
				}
				if(passWord.equals(oldPassWord)){
					bean.setACTION_RETURN_CODE("000000");
					bean.setACTION_RETURN_MESSAGE("登陆成功！");
					resultMap.put("data", dataList);
					bean.setACTION_INFO(resultMap);
				}else{
					bean.setACTION_RETURN_CODE("000003");
					bean.setACTION_RETURN_MESSAGE("登录名或密码错误!");
				}
			}else{
				bean.setACTION_RETURN_CODE("000003");
				bean.setACTION_RETURN_MESSAGE("登录名或密码错误！");
			}
		}else{
			bean.setACTION_RETURN_CODE("000003");
			bean.setACTION_RETURN_MESSAGE("请输入用户名和密码！");
		}
		
		return bean;
	}
	
	public JsonMessageBean regist(JSONObject obj) throws Exception{
		JsonMessageBean bean = new JsonMessageBean();
		
		String userName = obj.getString("registUserName");
		String loginName = obj.getString("registLoginName");
		String password = obj.getString("registPassword");
		String passWordAgin = obj.getString("registPasswordAgain");
		String userAge = obj.getString("registUserAge");
		int userSex = obj.getIntValue("userSex");
		if(validateObj.isNotEmpty(password) && validateObj.isNotEmpty(passWordAgin)){
			if(!password.equals(passWordAgin)){
				bean.setACTION_RETURN_CODE("000003");
				bean.setACTION_RETURN_MESSAGE("两次密码不一致");
				return bean;
			}
		}else{
			bean.setACTION_RETURN_CODE("000003");
			bean.setACTION_RETURN_MESSAGE("两次密码不能为空！");
			return bean;
		}
		
		User user = new User();
		User user1 = new User();
		String userId = String.valueOf(new Date().getTime());
		user1.setUserId(userId);
		List<User> dataList = userDao.getLogin(user1);
		if(dataList==null || dataList.size()<1){
			userId = String.valueOf(new Date().getTime());
		}
		String passWord = MD5.getMD5Str(password);
		user.setLoginName(loginName);
		user.setName(userName);
		user.setPassword(passWord);
		user.setSex(userSex);
		user.setUserId(userId);
		user.setAge(userAge);
		boolean flag = userDao.getRegist(user);
		if(flag){
			bean.setACTION_RETURN_CODE("000000");
			bean.setACTION_RETURN_MESSAGE("添加成功");
		}else{
			bean.setACTION_RETURN_CODE("000003");
			bean.setACTION_RETURN_MESSAGE("添加失败！");
		}
		return bean;
		
	}

}
