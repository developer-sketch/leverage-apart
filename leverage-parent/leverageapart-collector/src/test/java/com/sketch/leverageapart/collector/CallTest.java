package com.sketch.leverageapart.collector;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.util.MimeType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sketch.leverageapart.core.rawdata.KaptDetailResponse;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


public class CallTest {
	@Test
	public void kaptCall() throws Exception {	
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Jackson2JsonDecoder decoder = new Jackson2JsonDecoder(mapper, new MimeType("text", "plain", StandardCharsets.UTF_8), new MimeType("text", "html", StandardCharsets.UTF_8));
		
		Flux<KaptDetailResponse> response = Flux.just("A10024501","A13583301","A13582002").delayElements(Duration.ofSeconds(1)).map(aptCode -> {
			return WebClient.builder().codecs(clientCodecConfigurer -> clientCodecConfigurer.customCodecs().register(decoder)).baseUrl("http://www.k-apt.go.kr").build().post()
				.uri(uriBuilder -> uriBuilder.path("/kaptinfo/getKaptInfo_detail.do").build())
				.contentType(new MediaType("text", "html", StandardCharsets.UTF_8))
				.accept(new MediaType("text", "html", StandardCharsets.UTF_8))
				.body(BodyInserters.fromFormData("kapt_code", aptCode))
				.retrieve()
				.bodyToFlux(KaptDetailResponse.class).log();
			}).blockLast();
		
		
		StepVerifier.create(response)
			.expectSubscription()
			.consumeNextWith(res -> {})
			.verifyComplete();
	}
}
