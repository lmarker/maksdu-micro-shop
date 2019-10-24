package com.maksdu.good.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="maksdu_good_message")
@EqualsAndHashCode(callSuper=true)
@ApiModel(parent=DomainBase.class)
public class Good extends DomainBase {

	/**
	 * 商品主题
	 */
	@ApiModelProperty(name="goodTheme", value="商品主题")
	private String goodTheme;
	
	/**
	 * 商品描述
	 */
	@ApiModelProperty(name="goodDescription", value="商品描述")
	private String goodDescription;
	
	/**
	 * 商品预览图片
	 */
	@ApiModelProperty(name="previewPicture", value="预览图片")
	private String previewPicture;
	
	/**
	 * 商品剩余库存
	 */
	@ApiModelProperty(name="remainNumber", value="剩余库存")
	private Integer remainNumber;
	
	/**
	 * 商品上架时间
	 */
	@ApiModelProperty(name="startSaleTime", value="商品上架时间")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startSaleTime;
	
	/**
	 * 商品下架时间
	 */
	@ApiModelProperty(name="endSaleTime", value="商品下架时间")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endSaleTime;
	
	/**
	 * 商品价格
	 */
	@ApiModelProperty(name="price", value="商品价格")
	private Double price;
	
	@ApiModelProperty(name="status", value="商品状态")
	private Integer status; 
}
