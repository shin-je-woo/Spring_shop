package kpu.computer.jwshin.domain.shop;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int product_id;
	private String product_name;
	private int price;
	private String product_description;
	private String picture_url;
	private int remain;
	private MultipartFile file1; //첨부파일
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", product_description=" + product_description + ", picture_url=" + picture_url + ", remain=" + remain
				+ ", file1=" + file1 + "]";
	}
	
	
}
