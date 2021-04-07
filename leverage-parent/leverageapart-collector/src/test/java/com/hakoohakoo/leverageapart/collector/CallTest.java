package com.hakoohakoo.leverageapart.collector;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.hakoohakoo.leverageapart.rawdata.KaptDetailResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@Slf4j
public class CallTest {
	@Test
	public void kaptCall() {
		Flux<KaptDetailResponse> response = Flux.just("A10024501","A13583301","A13582002","1168010800").delayElements(Duration.ofSeconds(1)).map(aptCode -> {
			return WebClient.create("http://www.k-apt.go.kr").post()
				.uri(uriBuilder -> uriBuilder.path("/kaptinfo/getKaptInfo_detail.do").build())
				.contentType(new MediaType("text", "html", StandardCharsets.UTF_8))
				.accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromFormData("kapt_code", aptCode))
				.retrieve()
				.bodyToFlux(KaptDetailResponse.class);
			}).blockLast();
		
		
		StepVerifier.create(response)
			//.expectSubscription()
			.consumeNextWith(res -> log.debug("아파트 이름 : {}", res.getDetail().getName()))
			.verifyComplete();
	}
}
