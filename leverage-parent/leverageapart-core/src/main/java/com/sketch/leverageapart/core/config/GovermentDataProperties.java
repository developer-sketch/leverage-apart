package com.sketch.leverageapart.core.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "government.data")
public class GovermentDataProperties {
	private String serviceKey;
	private String domain;
}
