/*package test.code.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class DBConfiguration {

	@Value("${spring.redis.host}")
	private String hostName;
	
	
	@Value("${spring.redis.port}")
	private Integer portNumber;
	
	
	public RedisTemplate<String, String> redisTemplate(){
		final RedisTemplate<String, String> redisTemplate = 
				   new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		
		redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(String.class));
		
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		
		RedisStandaloneConfiguration configuration = 
				new RedisStandaloneConfiguration(hostName, portNumber);
		//Build Jedis connection template
		JedisClientConfiguration jedisClientConf = JedisClientConfiguration.builder().build();
		
		JedisConnectionFactory factory = 
				    new JedisConnectionFactory(configuration, jedisClientConf);
		
		factory.afterPropertiesSet();
		redisTemplate.setConnectionFactory(factory);
		
		return redisTemplate;
		
		
	}
	
}*/
