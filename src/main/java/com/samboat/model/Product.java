package com.samboat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productName;
	private  int quantity;
	private int unitPrice;
	private int price;
	private String image;
	private String originOfProduct;
	private boolean isPurchased;
	
	
	public Product()
	{
		
	}

	public Product(int id,String productName, int quantity, int unitPrice, String image,  String originOfProduct,boolean isPurchased) {
		        super();
		        this.id = id;
		        this.productName = productName;
		        this.quantity = quantity;
		        this.unitPrice = unitPrice;
//		        this.price = unitPrice*quantity;
		        this.image =image;
		        this.originOfProduct =originOfProduct;
		        this.isPurchased =isPurchased;
	}
	 

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price =unitPrice*quantity; ;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOriginOfProduct() {
		return originOfProduct;
	}

	public void setOriginOfProduct(String originOfProduct) {
		this.originOfProduct = originOfProduct;
	}

	public boolean isPurchased() {
		return isPurchased;
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	

}
