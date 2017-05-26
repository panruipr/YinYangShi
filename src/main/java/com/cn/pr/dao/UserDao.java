package com.cn.pr.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cn.pr.dao.BaseDao;
import com.cn.pr.pojo.User;

@Component//将UserDao类注入到bean里面 
public class UserDao extends BaseDao{
	
	private static Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	public int selectCount(){
		System.out.println((Integer)getSqlMapClientTemplate().queryForObject("User.getTotalCount",null));
		return (Integer)getSqlMapClientTemplate().queryForObject("User.getTotalCount",null);
	}
	
	public List<User> getLogin(User userObj) throws SQLException{
		Object resultList = new ArrayList<UserDao>();
		resultList = getSqlMapClient().queryForList("User.getLogin", userObj);
		return (List<User>) resultList;
	}
	
	public boolean getRegist(User userObject) throws SQLException{
		boolean flag = false;
		int i = getSqlMapClient().update("User.insertUser", userObject);
		logger.info("新增了" + i + "记录");
		if(i>0){
			flag = true;
		}
		return flag;
	}
	
}
