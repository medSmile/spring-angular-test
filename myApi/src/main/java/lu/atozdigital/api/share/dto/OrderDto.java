package lu.atozdigital.api.share.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lu.atozdigital.api.response.ArticleResponse;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = -299528643165150658L;
	
	private long id;
	private String Reference ;
	private Date date;
	private List<ArticleResponse> articles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ArticleResponse> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleResponse> articles) {
		this.articles = articles;
	}
	
}
