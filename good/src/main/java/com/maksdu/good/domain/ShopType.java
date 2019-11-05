package com.maksdu.good.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="shop_type")
public class ShopType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	private String typeId;
	
	private String typeName;
	
	@Transient
	@OneToMany(targetEntity=ShopBean.class,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<ShopBean> shops;
}
