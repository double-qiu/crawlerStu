/**  
 * Project Name:blogSearch  
 * File Name:BlogServiceTest.java  
 * Package Name:BlogService  
 * Date:2016年12月21日下午3:02:09  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aido.service.BlogService;



/**  
 * ClassName: BlogServiceTest  
 * 业务单元测试
 * @author DOUBLE
 * @version   
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath*:spring.xml")
public class BlogServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private BlogService blogService;
	
	
	 @Test
	 public void getBlogTotalTest() {
		long total =  blogService.getBlogTotal("[置顶] SQLServer 2008以上误操作数据库恢复方法——日志尾部备份");
		System.out.println(total);
	 }
	
}
