package com.hakoohakoo.leverageapart.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "kapat.data")
public class KaptProperties {
	private String domain;
	private String accept;
}
