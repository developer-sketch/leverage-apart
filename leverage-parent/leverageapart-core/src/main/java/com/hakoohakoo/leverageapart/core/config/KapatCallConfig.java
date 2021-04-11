package com.hakoohakoo.leverageapart.core.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(KaptProperties.class)
@Configuration
public class KapatCallConfig {
	@Autowired
	private KaptProperties properties;
	
	@Bean
	public RestTemplate restForKapt() {
		RestTemplate rest = new RestTemplate();
		RootUriTemplateHandler.addTo(rest, properties.getDomain());
		
		rest.getMessageConverters().stream().forEach(converter -> {
			if (converter instanceof MappingJackson2HttpMessageConverter) {
				List<MediaType> mediaTypes = Arrays.asList(new MediaType("text", "plain", StandardCharsets.UTF_8), new MediaType("text", "html", StandardCharsets.UTF_8));
				((MappingJackson2HttpMessageConverter)converter).setSupportedMediaTypes(mediaTypes);
			}
		});
		
		List<ClientHttpRequestInterceptor> interceptors = rest.getInterceptors();
		interceptors.add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
					request.getHeaders().add("Accept", properties.getAccept());
				return execution.execute(request, body);
			}
		});
		rest.setInterceptors(interceptors);
		return rest;
	}
}
