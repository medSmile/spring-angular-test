package lu.atozdigital.api.share.dto;

import java.io.Serializable;

public class ArticleDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String price;
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
	public void setPicture(String picture) {
		this.picture = picture;
	}
	

}
