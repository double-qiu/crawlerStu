/**  
 * Project Name:blogSearch  
 * File Name:BlogServiceImpl.java  
 * Package Name:com.aido.service.impl  
 * Date:2016年12月21日下午2:22:28  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aido.dao.BlogDao;
import com.aido.service.BlogService;
import com.aido.vo.BlogVO;

/**  
 * ClassName: BlogServiceImpl  
 * csdn博客查询业务接口
 * @author DOUBLE
 * @version   
 */

@Service("blogService")
public class BlogServiceImpl implements BlogService {

	/**  
	 * @param searchParam
	 * @return
	 * Administrator
	 */
	@Autowired
	private BlogDao blogDao;
	
	@Override
	public long getBlogTotal(String searchParam) {
		return blogDao.getBlogTotal(searchParam);
	}

	/**  
	 * @param current
	 * @param rowCount
	 * @return
	 * Administrator
	 */
	@Override
	public List<BlogVO> getBlogPageQuery(int current, int rowCount,String info) {
		
		return blogDao.getBlogPageQuery(current,rowCount,info);
	}
}
