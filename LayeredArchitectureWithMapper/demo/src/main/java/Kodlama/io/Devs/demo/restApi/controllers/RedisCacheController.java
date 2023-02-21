package Kodlama.io.Devs.demo.restApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.demo.business.service.RedisCacheService;

@RestController
@RequestMapping("/api/test")
public class RedisCacheController {
	
	private int sayac = 0;
	
	@Autowired
	private RedisCacheService redisCacheService;
	
	@GetMapping
	public String cacheControl() throws InterruptedException {
		if(sayac==5) {
			redisCacheService.clearCach();
			sayac = 0;
		}	
		sayac++;
		return redisCacheService.longRunnigMethod();
	}

}
