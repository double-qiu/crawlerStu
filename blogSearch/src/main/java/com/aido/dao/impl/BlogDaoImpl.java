/**  
 * Project Name:blogSearch  
 * File Name:BlogDaoImpl.java  
 * Package Name:com.aido.dao.impl  
 * Date:2016年12月21日下午2:28:29  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.dao.impl;


import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aido.dao.BaseDao;
import com.aido.dao.BlogDao;
import com.aido.vo.BlogVO;

/**  
 * ClassName: BlogDaoImpl  
 * 数据库操作
 * @author DOUBLE
 * @version   
 */
@Repository("blogDaoImpl")
public class BlogDaoImpl  extends BaseDaoImpl implements BlogDao {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	
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
			sql.append(" and MATCH (tb.title,tb.author) AGAINST  ('"+searchParam+"')");
		}
		return jdbcTemplate.queryForInt(sql.toString());
	}

	/**  
	 * @param current
	 * @param rowCount
	 * @return
	 * @author DOUBLE
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BlogVO> getBlogPageQuery(int current, int rowCount,String info) {
		StringBuffer sql = new StringBuffer();
		int index = (current-1)*rowCount;
		sql.append("select *  from tb_content tb  where 1 = 1");
		if(StringUtils.isNotBlank(info)){
			sql.append(" and MATCH (tb.title,tb.author) AGAINST  ('"+info+"')");
		}
		sql.append("  limit "+index+","+rowCount);
		return baseDao.findListbySql(sql.toString(), BlogVO.class);
	}
}
