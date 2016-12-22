/**  
 * Project Name:blogSearch  
 * File Name:BlogDao.java  
 * Package Name:com.aido.dao  
 * Date:2016年12月21日下午2:27:39  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.dao;

import java.util.List;

import com.aido.vo.BlogVO;

/**  
 * ClassName: BlogDao  
 * 后台数据查询
 * @author DOUBLE
 * @version   
 */
public interface BlogDao {
	
	/**
	 *  getBlogTotal:获取查询总条数
	 *  @return_type:long
	 *  @author DOUBLE
	 *  @param searchParam
	 *  @return
	 */
	public long getBlogTotal(String searchParam);

	/**  
	 *  getBlogPageQuery:分页查询
	 *  @return_type:List<BlogVO>
	 *  @author DOUBLE
	 *  @param current
	 *  @param rowCount
	 *  @return  
	 */
	public List<BlogVO> getBlogPageQuery(int current, int rowCount,String info);
}
