package lu.atozdigital.api.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lu.atozdigital.api.response.ArticleResponse;

@Entity(name="orders")

public class OrderEntity {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false,length=100)
	private String Reference ;
	@Column(nullable=false)
	private Date date;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ArticleEntity> articles;
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
	public List<ArticleEntity> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleEntity> articles) {
		this.articles = articles;
	}

}
