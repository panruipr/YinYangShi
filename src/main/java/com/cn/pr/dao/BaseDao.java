package com.cn.pr.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @author Administrator
 *公用的Dao层，其他Dao均继承它
 */
public class BaseDao extends SqlMapClientDaoSupport{
	@Resource(name="sqlMapClient")
	private SqlMapClient sqlMapClient;
	
	@PostConstruct//完成sqlMapClient初始化工作
	private void initSqlMapClient() {
		// TODO Auto-generated method stub
		super.setSqlMapClient(sqlMapClient);
	}


}
