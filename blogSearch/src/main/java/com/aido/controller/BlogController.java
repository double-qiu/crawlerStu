package com.aido.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.pagemodel.DataGrid;
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
	@SuppressWarnings("resource")
	@RequestMapping(value="/getdoclist",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String getdoclist(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount,@RequestParam("searchPhrase") String info) throws Exception{
		String url = "http://localhost:8080/solr/tika";
		SolrClient solr = new HttpSolrClient(url);
		SolrQuery query2 = new SolrQuery();
		query2.set("q", info);
		QueryResponse response = solr.query(query2);
		SolrDocumentList list = response.getResults();
		
		SolrQuery query = new SolrQuery();
		query.setStart((current-1)*rowCount);
        query.setRows(rowCount);
		query.set("q", info);
		QueryResponse response2 = solr.query(query);
		SolrDocumentList list2 = response2.getResults();
		List<BlogVO> doclist=new ArrayList<BlogVO>();
	        for (SolrDocument document : list2) {
	            String file =(String) document.get("file");
	            String content =(String) document.get("content");
	            long size =(Long) document.get("size");
	            BlogVO doc=new BlogVO(file,size,content);
	            doclist.add(doc);
	        }
	    DataGrid<BlogVO> grid=new DataGrid<BlogVO>();
	    grid.setCurrent(current);
	    grid.setRowCount(rowCount);
	    grid.setTotal(list.getNumFound());
	    grid.setRows(doclist);
		return JSON.toJSONString(grid);
	}
	
	
	@RequestMapping("/search")
	String search(){
		return "search";
	}
}
