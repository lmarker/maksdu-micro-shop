package com.maksdu.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maksdu.good.service.UidGenService;

@RestController
public class UidGenController {

	@Autowired
	private UidGenService uidGenService;

	@GetMapping("/testuid")
	public String test() {
		return String.valueOf( uidGenService.getUid() );
	}

}
