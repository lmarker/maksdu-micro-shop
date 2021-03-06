package com.maksdu.good.domain;

import java.util.Date;

import lombok.Data;

@Data
public class GoodEntity {

	/**
	 * 商品主题
	 */
	private String goodTheme;
	
	/**
	 * 商品描述
	 */
	private String goodDescription;
	
	/**
	 * 商品预览图片
	 */
	private String previewPicture;
	
	/**
	 * 商品剩余库存
	 */
	private int remainNumber;
	
	/**
	 * 商品上架时间
	 */
	private Date startSaleTime;
	
	/**
	 * 商品下架时间
	 */
	private Date endSaleTime;
	
	/**
	 * 商品创建时间
	 */
	private Date createTime;
	
	/**
	 * 商品变更时间
	 */
	private Date updateTime;
	
	/**
	 * 商品价格
	 */
	private double price;
	
	
}
