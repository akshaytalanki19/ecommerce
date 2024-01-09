package com.ecommerce.website.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private int rid;
   private String pname;
   private String description;
   private int price;
   private int stock_qunatity;
   private Blob image;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStock_qunatity() {
	return stock_qunatity;
}
public void setStock_qunatity(int stock_qunatity) {
	this.stock_qunatity = stock_qunatity;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob img) {
	this.image = img;
}
   
}
