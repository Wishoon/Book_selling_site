package com.sales.book.admin.goods.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminGoodsVO {
	private String beginDate;
	private String endDate;
	private int section;
	private int pageNum;
	private int goods_id;
	private String goods_title;
	private String goods_writer;
	private String goods_publisher;
	private int goods_sales_price;
	private String goods_credate;
	private String goods_published_date;
	
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public String getGoods_writer() {
		return goods_writer;
	}
	public void setGoods_writer(String goods_writer) {
		this.goods_writer = goods_writer;
	}
	public String getGoods_publisher() {
		return goods_publisher;
	}
	public void setGoods_publisher(String goods_publisher) {
		this.goods_publisher = goods_publisher;
	}
	public int getGoods_sales_price() {
		return goods_sales_price;
	}
	public void setGoods_sales_price(int goods_sales_price) {
		this.goods_sales_price = goods_sales_price;
	}
	public String getGoods_credate() {
		return goods_credate;
	}
	public void setGoods_credate(String goods_credate) {
		this.goods_credate = goods_credate;
	}
	public String getGoods_published_date() {
		return goods_published_date;
	}
	public void setGoods_published_date(String goods_published_date) {
		this.goods_published_date = goods_published_date;
	}
	
	@Override
	public String toString() {
		return "AdminGoodsVO [beginDate=" + beginDate + ", endDate=" + endDate + ", section=" + section + ", pageNum="
				+ pageNum + ", goods_id=" + goods_id + ", goods_title=" + goods_title + ", goods_writer=" + goods_writer
				+ ", goods_publisher=" + goods_publisher + ", goods_sales_price=" + goods_sales_price
				+ ", goods_credate=" + goods_credate + ", goods_published_date=" + goods_published_date + "]";
	}
	
}
