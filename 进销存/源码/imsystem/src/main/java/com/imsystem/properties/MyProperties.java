package com.imsystem.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="my")
@PropertySource("classpath:my.properties")
public class MyProperties {

	
	private String fileupload;
	
	private String wxpoint;
	
	private String qqpoint;

	public String getFileupload() {
		return fileupload;
	}

	public void setFileupload(String fileupload) {
		this.fileupload = fileupload;
	}

	public String getWxpoint() {
		return wxpoint;
	}

	public void setWxpoint(String wxpoint) {
		this.wxpoint = wxpoint;
	}

	public String getQqpoint() {
		return qqpoint;
	}

	public void setQqpoint(String qqpoint) {
		this.qqpoint = qqpoint;
	}
	
	
	
	
}
