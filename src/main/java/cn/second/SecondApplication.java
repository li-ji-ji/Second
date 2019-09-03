package cn.second;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(exclude={DataSourceAutoCfxonfiguration.class})
@SpringBootApplication
@MapperScan("cn.second.lhj.authority.mapper")
@EnableDiscoveryClient //启用服务注册与发现
@EnableFeignClients //启用feign进行远程调用
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}
}
