package com.maksdu.good.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maksdu.good.domain.Good;
import com.maksdu.good.service.GoodDataSourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags= {"good"})
public class GoodController {

	private GoodDataSourceService goodDataSourceService;

	@Autowired
	public void setGoodDataSourceService(GoodDataSourceService goodDataSourceService) {
		this.goodDataSourceService = goodDataSourceService;
	}
	
	@GetMapping(value="init")
	@ApiOperation(value="init", notes="init object for good moudle")
	public Good initNewGood() {
		return new Good();
	}
	
	@PostMapping(value="createSingle")
	public Good createNewGood(@RequestBody Good good) {
		return goodDataSourceService.save(good);
	}
	
	@PostMapping(value="createBatch")
	public List<Good> createBatchNewGood(@RequestBody List<Good> goods) {
		return goodDataSourceService.saveAll(goods);
	}
	
	@PostMapping(value="update")
	public Good updateOldGood(Good good) {
		return goodDataSourceService.update(good);
	}
	
	@PostMapping(value="delete")
	public Good deleteGood(Good good) {
		return goodDataSourceService.delete(good);
	}
	
	@GetMapping(value="/{id}")
	public Good getGood(@PathVariable String id) {
		return goodDataSourceService.getOne(id);
	}
	
	
}
