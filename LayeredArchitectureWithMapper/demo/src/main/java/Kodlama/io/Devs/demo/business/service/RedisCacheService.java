package Kodlama.io.Devs.demo.business.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
	
	@Cacheable(cacheNames = "mySpecialCache")  // methodun Cach'lenmesini belirttik
	public String longRunnigMethod() throws InterruptedException {
		Thread.sleep(5000L);
		return "method calisti";
	}
	
	@CacheEvict(cacheNames = "mySpecialCache")  //cach'i bitiriyor
	public void clearCach() {
		System.out.println("cache temizlendi");
	}
	
}
