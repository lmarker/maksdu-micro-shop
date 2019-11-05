package com.maksdu.good.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="shop_message")
@ApiModel(value="商品Bean", parent=DomainBase.class)
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class ShopBean extends DomainBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商品主题
	 */
	@ApiModelProperty(name="goodTheme", value="商品主题", dataType="String")
	private String goodTheme;
	
	/**
	 * 商品描述
	 */
	@ApiModelProperty(name="goodDescription", value="商品描述", dataType="String")
	private String goodDescription;
	
	/**
	 * 商品预览图片
	 */
	@ApiModelProperty(name="previewPicture", value="预览图片", dataType="String")
	private String previewPicture;
	
	/**
	 * 商品剩余库存
	 */
	@ApiModelProperty(name="remainNumber", value="剩余库存", dataType="Integer")
	private Integer remainNumber;
	
	/**
	 * 商品上架时间
	 */
	@ApiModelProperty(name="startSaleTime", value="商品上架时间", dataType="Date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startSaleTime;
	
	/**
	 * 商品下架时间
	 */
	@ApiModelProperty(name="endSaleTime", value="商品下架时间", dataType="Date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endSaleTime;
	
	/**
	 * 商品价格
	 */
	@ApiModelProperty(name="price", value="商品价格", dataType="String")
	private BigDecimal price;
	
	@ApiModelProperty(name="status", value="商品状态", dataType="String")
	private Integer status; 

	@ManyToOne(fetch=FetchType.EAGER,targetEntity=ShopType.class)
	@JoinColumn(name="typeid",referencedColumnName="typeid")
	private ShopType shopType;
}
