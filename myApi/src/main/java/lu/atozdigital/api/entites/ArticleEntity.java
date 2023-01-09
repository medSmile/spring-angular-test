package lu.atozdigital.api.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="articles")
public class ArticleEntity {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false,length=30)
	private String name;
	@Column(nullable=false,length=100)
	private String price;
	@Column(nullable=false,length=100)
	private String picture;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String pricture) {
		this.picture = pricture;
	}
	

}
