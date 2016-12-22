package com.aido.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_content")
public class BlogVO {
	
	
	private long id;
	private String title;
	private String url;
	private String html;
	private String author;
	
	public BlogVO(long id, String title, String url,String html,String author) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.html = html;
		this.author = author;
	}
	public BlogVO() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id",nullable=false,length=36)
	public long getId() {
		return id;
	}

	/**  
	 * id.  
	 *  
	 * @param   id    the id to set    
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**  
	 * title.  
	 *  
	 * @return  the title  
	 */
	@Column(name ="title",nullable=true,length=300)
	public String getTitle() {
		return title;
	}

	/**  
	 * title.  
	 *  
	 * @param   title    the title to set    
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**  
	 * url.  
	 *  
	 * @return  the url  
	 */
	@Column(name ="url",nullable=true,length=300)
	public String getUrl() {
		return url;
	}

	/**  
	 * url.  
	 *  
	 * @param   url    the url to set    
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**  
	 * html.  
	 *  
	 * @return  the html  
	 */
	@Column(name ="html",nullable=true,length=300)
	public String getHtml() {
		return html;
	}

	/**  
	 * html.  
	 *  
	 * @param   html    the html to set    
	 */
	public void setHtml(String html) {
		this.html = html;
	}
	/**  
	 * author.  
	 *  
	 * @return  the author  
	 */
	@Column(name ="author",nullable=true,length=300)
	public String getAuthor() {
		return author;
	}
	/**  
	 * author.  
	 *  
	 * @param   author    the author to set    
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
}
