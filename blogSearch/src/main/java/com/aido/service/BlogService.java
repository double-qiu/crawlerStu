/**  
 * Project Name:blogSearch  
 * File Name:BlogService.java  
 * Package Name:com.aido.service  
 * Date:2016年12月21日下午2:18:34  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.service;

/**  
 * ClassName: BlogService  
 * csdn博客查询业务接口
 * @author DOUBLE
 * @version   
 */
public interface BlogService {
	
	/**
	 *  getBlogTotal:获取查询总条数
	 *  @return_type:int
	 *  @author DOUBLE
	 *  @param searchParam
	 *  @return
	 */
	public long getBlogTotal(String searchParam);
}
