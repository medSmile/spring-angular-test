package lu.atozdigital.api.response;

import java.util.Date;
import java.util.List;

public class OrderResponse {
	
	private String Reference ;
	private Date date;
	private List<ArticleResponse> articles;
	
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
