/**  
 * Project Name:blogSearch  
 * File Name:BlogDaoImpl.java  
 * Package Name:com.aido.dao.impl  
 * Date:2016年12月21日下午2:28:29  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.dao.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.aido.dao.BlogDao;

/**  
 * ClassName: BlogDaoImpl  
 * 数据库操作
 * @author DOUBLE
 * @version   
 */


@Repository("blogDaoImpl")
public class BlogDaoImpl  extends BaseDaoImpl implements BlogDao {

	/**
	 * @param searchParam
	 * @return
	 * @author DOUBLE
	 */
	@SuppressWarnings("deprecation")
	@Override
	public long getBlogTotal(String searchParam) {
		StringBuffer sql = new StringBuffer();
		sql.append("select COUNT(tb.id)  from tb_content tb where 1 = 1  ");
		if(StringUtils.isNotBlank(searchParam)){
			sql.append(" and MATCH (tb.title) AGAINST  ('"+searchParam+"')");
		}
		return jdbcTemplate.queryForInt(sql.toString());
	}
}
