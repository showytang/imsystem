package com.imsystem.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcMyConfig extends WebMvcConfigurationSupport {
	
	/**
	 * 跨域
	 */
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}
	/**
	 * 静态资源处理：
	 * 
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		//本工程
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:static/");
		//工程以外的静态资源
		registry.addResourceHandler("/upload/**")
		.addResourceLocations("file:d:/upload/");
	}
	
	/**
	 * 普通字符串乱码
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringMessageConverter() {
		StringHttpMessageConverter msg = 
				new StringHttpMessageConverter(StandardCharsets.UTF_8);
		return msg;
	}
	@Bean
	public ByteArrayHttpMessageConverter byteArrayMessageConverter() {
		ByteArrayHttpMessageConverter c = new ByteArrayHttpMessageConverter();
		return c;
	}
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
	
	
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(stringMessageConverter());
		converters.add(byteArrayMessageConverter());
		converters.add(mappingJackson2HttpMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	/*@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
	}	*/
}
