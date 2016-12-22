package com.aido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.pagemodel.DataGrid;
import com.aido.service.BlogService;
import com.aido.vo.BlogVO;
import com.alibaba.fastjson.JSON;

/**
 * ClassName: DocController  
 * csdn博客搜索
 * @author DOUBLE
 * @version
 */
@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	/**
	 *  getdoclist:本地文档搜索
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @param current
	 *  @param rowCount
	 *  @param info
	 *  @return
	 *  @throws Exception
	 */
	@RequestMapping(value="/getdoclist",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String getdoclist(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount,@RequestParam("searchPhrase") String info) throws Exception{
		List<BlogVO> blogVOList  =  blogService.getBlogPageQuery(current,rowCount,info);
		List<BlogVO> doclist=new ArrayList<BlogVO>();
		
		for (BlogVO blogVO : blogVOList) {
			long id = blogVO.getId();
			String title = blogVO.getTitle();
			String url = blogVO.getUrl();
			String html = blogVO.getHtml();
			String author = blogVO.getAuthor();
	        BlogVO doc=new BlogVO(id,title,url,html,author);
	        doclist.add(doc);
		}
		long total =  blogService.getBlogTotal(info);
	    DataGrid<BlogVO> grid=new DataGrid<BlogVO>();
	    grid.setCurrent(current);
	    grid.setRowCount(rowCount);
	    grid.setTotal(total);
	    grid.setRows(doclist);
		return JSON.toJSONString(grid);
	}
	@RequestMapping("/search")
	String search(){
		return "search";
	}
}
