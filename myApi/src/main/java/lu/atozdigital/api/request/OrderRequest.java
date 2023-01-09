package lu.atozdigital.api.request;

import java.util.List;

import lu.atozdigital.api.response.ArticleResponse;

public class OrderRequest {
	
	
	private List<ArticleResponse> articles;
	
	
	public List<ArticleResponse> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleResponse> articles) {
		this.articles = articles;
	}

}
