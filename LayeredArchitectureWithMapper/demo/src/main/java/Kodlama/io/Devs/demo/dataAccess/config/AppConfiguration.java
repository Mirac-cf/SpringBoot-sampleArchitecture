package Kodlama.io.Devs.demo.dataAccess.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching  //springin cashing mekanizmasını devreye almasını saglayan anotasyon
public class AppConfiguration {
	
	// redis bağlantısını saglayan JedisConnectionFactory instance
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost",6379);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	
	
	@Bean
	public RedisTemplate redisTemlate() {
		RedisTemplate template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
	
}
