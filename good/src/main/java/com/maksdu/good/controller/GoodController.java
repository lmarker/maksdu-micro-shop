package com.maksdu.good.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maksdu.good.domain.ShopBean;
import com.maksdu.good.service.GoodDataSourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags= {"good"})
@RequestMapping("/good")
public class GoodController {

	private GoodDataSourceService goodDataSourceService;

	@Autowired
	public void setGoodDataSourceService(GoodDataSourceService goodDataSourceService) {
		this.goodDataSourceService = goodDataSourceService;
	}
	
	@GetMapping(value="init")
	@ApiOperation(value="init", notes="init object for good moudle")
	public ShopBean initNewGood() {
		return new ShopBean();
	}
	
	@PostMapping(value="createSingle")
	public ShopBean createNewGood(@RequestBody ShopBean good) {
		return goodDataSourceService.save(good);
	}
	
	@PostMapping(value="createBatch")
	public List<ShopBean> createBatchNewGood(@RequestBody List<ShopBean> goods) {
		return goodDataSourceService.saveAll(goods);
	}
	
	@PostMapping(value="update")
	public ShopBean updateOldGood(ShopBean good) {
		return goodDataSourceService.update(good);
	}
	
	@PostMapping(value="delete")
	public ShopBean deleteGood(ShopBean good) {
		return goodDataSourceService.delete(good);
	}
	
	@GetMapping(value="/{id}")
	public ShopBean getGood(@PathVariable String id) {
		return goodDataSourceService.getOne(id);
	}
	
	
}
