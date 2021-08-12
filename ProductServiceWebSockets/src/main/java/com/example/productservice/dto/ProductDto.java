package com.example.productservice.dto;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {
	
	@Id
	private Integer id;
	private String description;
	private Integer price;
	private String subscriber;

	
	public ProductDto(Integer id, String description, Integer price, String subscriber) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.subscriber = subscriber;
	}
	
	public ProductDto() {}
	
	public ProductDto id(ProductDto product) {
		return new ProductDto(product.getId(),
				product.getDescription(),
				product.getPrice(),
				product.getSubscriber());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

}
